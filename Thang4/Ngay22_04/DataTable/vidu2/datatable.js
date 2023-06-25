// $(document).ready(function(){
    
// })

console.log("import datatable.js")

var urlUser = "https://jsonplaceholder.typicode.com/users";


let array = {

     initDataTable: function(){
        // var data = [
        //     {
        //       "id": 1,
        //       "name": "Leanne Graham",
        //       "username": "Bret",
        //       "email": "Sincere@april.biz"},
        //       {
        //         "id": 2,
        //         "name": "Ervin Howell",
        //         "username": "Antonette",
        //         "email": "Shanna@melissa.tv"},
        //         {
        //             "id": 1,
        //             "name": "Leanne Graham",
        //             "username": "Bret",
        //             "email": "Sincere@april.biz"},
        //             {
        //               "id": 2,
        //               "name": "Ervin Howell",
        //               "username": "Antonette",
        //               "email": "Shanna@melissa.tv"},
        //               {
        //                 "id": 1,
        //                 "name": "Leanne Graham",
        //                 "username": "Bret",
        //                 "email": "Sincere@april.biz"},
        //                 {
        //                   "id": 2,
        //                   "name": "Ervin Howell",
        //                   "username": "Antonette",
        //                   "email": "Shanna@melissa.tv"}
            
        //     ]
        
            $.get(urlUser,function(respondse){
                alert(`respondse = ${JSON.stringify(respondse)}`);
                table = $('#example').DataTable({
                    "processing":true,
                    searching:false,
                    lengthMenu:false,
                    pageLength:10,
                    data:respondse,
                    columns: [
                        {
                            data: 'id'
                        },
                        {
                            data: 'name'
                        },
                        {
                            data: 'username'
                        },
                        {
                            data: 'email'
                        }
                    ]
                })
            })
           
        }
}




function encrypt() {
    var key = CryptoJS.enc.Utf8.parse('75b8e01ec81c9a390a144a938b8b8e81');
    var iv = CryptoJS.enc.Utf8.parse('75b8e01ec81c9a390a144a938b8b8e81');
    var value = CryptoJS.enc.Utf8.parse('22aXo0XqjcWnXScaevvEJeFK5HustM+jAp9aOfoQpFg=')

    var encryptValue = CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse('hehe'), key, {
      keySize: 128 / 8,
      iv: iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    })
    return encryptValue.toString();
  }

  function decrypt() {
    var key = CryptoJS.enc.Utf8.parse('75b8e01ec81c9a390a144a938b8b8e81');
    var iv = CryptoJS.enc.Utf8.parse('75b8e01ec81c9a390a144a938b8b8e81');
    var d = CryptoJS.AES.decrypt('0pGFo8Z7ckJiKfF2e4mHeg==', key, {
      keySize: 128 / 8,
      iv: iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    })
    return CryptoJS.enc.Utf8.stringify(d);
  }




  console.log(encrypt);

// const SinhVien = [
//     { msv: "SV1", ten: "Ngọc Anh" },
//     { msv: "SV2", ten: "Tiểu Bảo" },
//     { msv: "SV3", ten: "Hàn Lập" }
// ];

// const doDaiTenSinhVien = SinhVien.map(sv => {
//     const obj = {};

//     obj[sv.msv] = sv.ten;
//     obj.doDaiTen = sv.ten.length;

//     return obj; 
// });

// console.log(doDaiTenSinhVien);

let arrBanKinh = [10,20,30];

function tinhBinhPhuong(x){
    return x*x;
}

let arrDienTich = arrBanKinh.map(tinhBinhPhuong);
console.log

// ghép họ và tên bằng cách sử dụng hàm map

const SinhVien = [
    { msv: "SV1", ten: "Ngọc Anh" },
    { msv: "SV2", ten: "Tiểu Bảo" },
    { msv: "SV3", ten: "Hàn Lập" }
];

function  layTenDayDu(sv,phantucach){
    
    return sv.msv +phantucach+sv.ten;
}

console.log(SinhVien);

let arrSinhVien = SinhVien.map(layTenDayDu);
console.log(arrSinhVien);


const doDaiTenSinhVien = SinhVien.map(sv =>{
    let obj = {};
    obj.msv = sv.msv;
    obj.ten= sv.ten;
    obj.dodaiten = sv.ten.length;
    return obj;
    
   
})
console.log(doDaiTenSinhVien);