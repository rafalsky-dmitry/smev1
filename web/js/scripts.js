function add_new_row() {
    var tr = document.createElement('tr');
    var td = document.createElement('td');
    td.innerHTML = "Новая строка";
    tr.appendChild(td);
    document.getElementById('tb').appendChild(tr);
}

/*
** Функция получает все данные
 */
function get_json() {

    var ajax = new XMLHttpRequest();
    ajax.open('GET', 'http://smart-route.ru:8100/adapter-web/rest/dictionary/c580d006-f86f-4bdd-84be-b51de6f626c6', false);
    ajax.send();
    var response = ajax.responseText;
    window.context = JSON.parse(response);
    window.page = 0;
    build()
}

/*
** Функция осуществляет живой поиск данных на странице
 */
function search() {
    var i=0;
    var len = window.context['documents'].length;
    var text = $("#search").val();
    var len2 = text.length;
    if (text != "" && len2 > 2) {
        $(".row").remove();
        var pos = -1;
        var pos2 = -1;
        var pos3 = -1;
        var pos4 = -1;
        var success = 0;
        for (i=0; i<len; i++) {
            pos = window.context['documents'][i].fio.toLowerCase().indexOf(text.toLowerCase());
            pos2 = window.context['documents'][i].gender.toLowerCase().indexOf(text.toLowerCase());
            pos3 = window.context['documents'][i].birthDate.toLowerCase().indexOf(text.toLowerCase());
            pos4 = window.context['documents'][i].phone.toLowerCase().indexOf(text.toLowerCase());
            if (pos >= 0 || pos2 >= 0 || pos3 >= 0 || pos4 >= 0) {
                add(i);
                success++;
            }
        }
        console.log(success);
        if (success > 0) {
            $("#message").val("Найдено " + success + " записей");
            $("#message").css('color', 'green');
        } else {
            $("#message").val("Ничего не найдено");
            $("#message").css('color', 'red');
        }
    } else {
        $("#message").val("Введите более 2-х символов");
        $("#message").css('color', 'black');
        build();
    }
}

function add(i) {
    var tr = document.createElement('tr');
    var fio = document.createElement('td');
    var gender = document.createElement('td');
    var bd = document.createElement('td');
    var phone = document.createElement('td');
    fio.innerHTML = window.context['documents'][i].fio;
    fio.className = "rows";
    tr.appendChild(fio);
    gender.innerHTML = window.context['documents'][i].gender;
    gender.className = "row";
    tr.appendChild(gender);
    bd.innerHTML = window.context['documents'][i].birthDate;
    bd.className = "row";
    tr.appendChild(bd);
    phone.innerHTML = window.context['documents'][i].phone;
    phone.className = "row";
    tr.appendChild(phone);
    tr.id = i;
    tr.className = "row";
    document.getElementById('tb').appendChild(tr);
}

function change_page(num) {
    var len = window.context['documents'].length;
    var kol_on_page = $("#kol_on_page").val();
    var kol_page = len/kol_on_page;
    if (len % kol_on_page > 0) kol_page++;
    console.log("n page" + window.page);
    console.log("kol page" + kol_page);
    if (num == '+' && window.page < kol_page-2) {
        window.page++;
        build();
    }
    if (num == '-' && window.page > 0) {
        window.page--;
        build();
    }
}

function build() {
    var i = 0;
    var len = window.context['documents'].length;
    var kol_on_page = $("#kol_on_page").val();
    var srart = 0;
    var end = 0;
    $("#all_item").val("Всего записей: " + len);
    $(".row").remove();  // Как удалить все элементы класса на чистом JS????
    if (kol_on_page != "Все записи") {
        var kol_page = Math.floor(len/kol_on_page);
        if (len % kol_on_page > 0) kol_page++;
        start = window.page * kol_on_page;
        end = start + kol_on_page * 1;
        if (end > len) end = len;
        $("#kol_pages").val("Количество страниц: " + kol_page);
    } else {
        start = 0;
        end = len;
        $("#kol_pages").val("Количество страниц: 1");
    }
    $("#pages").val("Показаны записи с " + start + " по " + end);
    for (i=start; i<end; i++) {
        add(i);
    }
}

function send_data() {
    var name = $('#name').val();
    var pas = $('#pas').val();
    console.log(name + " " + pas);
    if (name == "" || pas == "") {
        $('#message-zapros').val("Введите имя и пароль");
    } else {
        var json = {
            "name" : name,
            "pas" : pas
        }
        var ajax = new XMLHttpRequest();
        //var url = 'http://127.0.0.1:8082/web-start/login?name='+name+'&pas='+pas;
        var url = '/web-start/login?name='+name+'&pas='+pas;
        ajax.open('GET', url, false);
        ajax.send();
        var response = ajax.responseText;
        console.log(response);
        $('#message-zapros').val(response);
    }
}