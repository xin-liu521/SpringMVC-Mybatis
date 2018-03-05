function tkSave() {
    var tkbackdate = $("#tkbackdate").datebox('getValue');
    var tkBacktype = $("input[name='tkBacktype']").is(":checked");
    if (tkbackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }
    if (tkBacktype == false) {
        Command: toastr["warning"]("请选择归还方式");
        return;
    }

}

function gpSave() {
    var gpbackdate = $("#gpbackdate").datebox('getValue');
    var gpBacktype = $("input[name='gpBacktype']").is(":checked");
    if (gpbackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }
    if (gpBacktype == false) {
        Command: toastr["warning"]("请选择归还方式");
        return;
    }
}

function sySave() {
    var sybackdate = $("#sybackdate").datebox('getValue');
    var syBacktype = $("input[name='syBacktype']").is(":checked");
    if (sybackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }
    if (syBacktype == false) {
        Command: toastr["warning"]("请选择归还方式");
        return;
    }
}

function wmSave() {
    var wmbackdate = $("#wmbackdate").datebox('getValue');
    var wmBacktype = $("input[name='wmBacktype']").is(":checked");
    if (wmbackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }
    if (wmBacktype == false) {
        Command: toastr["warning"]("请选择归还方式");
        return;
    }
}

function dcSave() {
    var dcbackdate = $("#dcbackdate").datebox('getValue');
    var dcBacktype = $("input[name='dcBacktype']").is(":checked");
    if (dcbackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }
    if (dcBacktype == false) {
        Command: toastr["warning"]("请选择归还方式");
        return;
    }
}

function pxSave() {
    var pxbackdate = $("#pxbackdate").datebox('getValue');
    var pxfeetype = $("input[name='pxfeetype']").is(":checked");
    if (pxbackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }
    if (pxfeetype == false) {
        Command: toastr["warning"]("请选择归还方式");
        return;
    }
}

function bxSave() {
    var bxbackdate = $("#bxbackdate").datebox('getValue');
    if (bxbackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }

}

function htSave() {
    var htbackdate = $("#htbackdate").datebox('getValue');
    if (htbackdate == '') {
        Command: toastr["warning"]("归还时间不能为空");
        return;
    }
}

