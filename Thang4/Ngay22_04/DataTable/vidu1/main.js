let organManage = {
    organSetting: {
        host: "/people/get-all",
        mod: "release",
        debugAgent: "web",
        root: $("#main-content"),
        cookie: 1,
        pathPlugin: "/asset",
        requestTimeout: 5000, // Timeout request for ajax,
        dataTable: null,
        mode: "system"
    },
    init: function () {
        let instance = this;

        if (typeof jQuery === 'undefined') {
            edocDocument.log("Can not load jQuery environment");
            return;
        }
        instance.renderOrganDatatable();
    },
    renderOrganDatatable: function () {
        let instance = this;
        instance.organSetting.dataTable = $('#dataTables-organ').DataTable({
            serverSide: true,
            processing: true,
            pageLength: 25,
            ajax: {
                url: "people/get-all",
                type: "GET"
            },
            drawCallback: function () {
               
                $(this).contextMenu({
                    selector: 'tr td',
                    callback: function (key, options) {
                        let id = options.$trigger[0].parentElement.id;
                        let m = "clicked: " + key + ' ' + id;
                        switch (key) {
                            case "delete":
                                //instance.deleteOrgan(id);
                                alertDelete(instance, id);
                                break;
                            case "edit":
                                editOrganClick(id);
                                break;
                        }
                    },
                    items: {
                        "edit": {name: organ_message.manage_edit_organ, icon: "edit"},
                        /*"cut": {name: "Cut", icon: "cut"},
                        copy: {name: "Copy", icon: "copy"},
                        "paste": {name: "Paste", icon: "paste"},*/
                        "delete": {name: organ_message.manage_remove_organ, icon: "delete"}
                        /*"sep1": "---------",*/
                        /*"quit": {name: "Quit", icon: function(){
                                return 'context-menu-icon context-menu-icon-quit';
                            }}*/
                    }
                });
            },
            rowId: "id",
            responsive: true,
            autoWidth: false,
            ordering: true,
            bDestroy: true,
            searching: true,
            lengthChange: false,
            paging: true,
            info: false,
            columnDefs: [{
                "defaultContent": "",
                "targets": "_all"
            }],
            columns: [
                {
                    "name": "id",
                    "title":"id",
                    "data": null,
                    // "render": function (data) {
                    //     return $('#organNameTemplate').tmpl(data).html();
                    // }
                },
                {
                    "name": "address",
                    "title": "Địa chỉ",
                    "data": "address",
                },
                {
                    "name": "name",
                    "title": "name",
                    "data":  null
                    // "render": function (data) {
                    //     console.log(data)
                    //     if(data.domain_new != null){
                    //         return data.domain_new;
                    //     }

                    // }
                }
            ],
            // language: app_message.language,
            order: [[3, "desc"]]
        });
    },
    reGenerateToken: function (organId) {
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: "/contact/-/document/contact/token/" + organId,
            cache: false,
            success: function (response) {
                $.notify(organ_message.token_edit_success, "success");
                console.log(response)
                $("#token").val(response.token);
            },
            error: function (error) {
                $.notify(organ_message.token_edit_fail, "error");
            }
        });
    },

    createOrgan: function (e) {
        let instance = this;
        // anhvty
        let name = $("#name").val();
        let domain = $("#domain").val();
        let domain_new = $("#domain_new").val();
        let address = $("#address").val();
        let email = $("#email").val();
        let inCharge = $("#inCharge").val();
        let telephone = $("#telephone").val();
        let agency = checkAgencySelected();
        let receiveNotify = checkReceivedNotify();
        let sendToVPCP = checkSendToVPCP();

        if (validateOrgan(name, domain, domain_new, inCharge, address, email)) {
            //console.log(app_message.edoc_validate_document_request_fail);
            //e.preventDefault();
        } else {
            let contactRequest = {
                "name": name,
                "domain": domain,
                "domain_new":domain_new,
                "address": address,
                "email": email,
                "inCharge": inCharge,
                "telephone": telephone,
                "agency": agency,
                "receiveNotify": receiveNotify,
                "sendToVPCP": sendToVPCP
            };
            $.ajax({
                type: "POST",
                contentType: "application/json;charset=utf-8",
                url: "/public/-/organ/create",
                data: JSON.stringify(contactRequest),
                cache: false,
                success: function (response) {
                    if (response.code === 200) {
                        $.notify(organ_message.organ_add_new_success, "success");
                        $.notify(response.message, "success");
                        $('#addNewOrgan').trigger("reset");
                        $('#formAddOrgan').modal('toggle');
                        organManage.renderOrganDatatable();
                    } else {
                        $.notify(organ_message.organ_add_new_fail, "error");
                    }
                },
                error: function (error) {
                    $.notify(error.responseJSON.errors, "error");
                }
            });
        }
    },

    editOrgan: function (id) {
        let instance = this;

        let name = $("#editName").val();
        let domain = $("#editDomain").val();
        let address = $("#editAddress").val();
        let email = $("#editEmail").val();
        let domain_new = $("#editDomainNew").val();
        let inCharge = $("#editInCharge").val();
        let telephone = $("#editTelephone").val();
        let agency = checkAgencySelected();
        let receiveNotify = checkReceivedNotify();
        let sendToVPCP = checkSendToVPCP();
        let integratorCenter = checkIntegratorCenter();
        let contact_egov = $("#editcontactEgov").val();
        let is_egov = checkIsEgov();
        let contactRequest = {
            "id": id,
            "name": name,
            "domain": domain,
            "domain_new":domain_new,
            "address": address,
            "email": email,
            "inCharge": inCharge,
            "telephone": telephone,
            "agency": agency,
            "receiveNotify": receiveNotify,
            "sendToVPCP": sendToVPCP,
            "integratorCenter": integratorCenter,
            "contact_egov": contact_egov,
            "is_egov":is_egov
        };
        $.ajax({
            type: "PUT",
            contentType: "application/json;charset=utf-8",
            url: "/contact/-/update/contact",
            data: JSON.stringify(contactRequest),
            cache: false,
            beforeSend: function () {
                $("#overlay").show();
            },
            success: function (response) {
                if (response.code === 200) {
                    $.notify(organ_message.organ_edit_success, "success");
                    $.notify(response.message, "success");
                } else {
                    $.notify(organ_message.organ_edit_fail, "error");
                }
            },
            error: function (error) {
                $.notify(organ_message.organ_edit_fail, "error");
            }
        }).done(function () {
            $("#overlay").hide();
            $('#formEditOrgan').modal('toggle');
            organManage.renderOrganDatatable();
        })
    },
    deleteOrgan: function (organId) {

        let instance = this;
        if (organId !== null && organId !== "") {
            $.ajax({
                url: "/public/-/organ/delete/" + organId,
                type: "DELETE",
                statusCode: {
                    200: function (response) {
                        $.notify(organ_message.organ_delete_success, "success");
                        $("#" + organId).remove();
                        organManage.renderOrganDatatable();
                    },
                    400: function (response) {
                        $.notify(organ_message.organ_delete_fail, "error");
                    },
                    500: function (response) {
                        $.notify(organ_message.organ_delete_fail, "error");
                    }
                }
            })
        }
    }

}

//MinhTD
function alertDelete(instance, id) {
    Swal.fire({
        title: "Are you sure?",
        text: "Bạn có chắc chắn muốn xóa!",
        type: "warning",
        showCancelButton: true,
        confirmButtonText: "Xóa",
        cancelButtonText: "Hủy",
        closeOnConfirm: false,
        closeOnCancel: false
    }).then((result) => {
        if (result.isConfirmed)
            instance.deleteOrgan(id);
    });
}
