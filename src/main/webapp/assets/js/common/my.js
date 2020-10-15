function isForbiddenCover(fobid) {
	if ($.type(fobid) === 'number') {
		return (fobid == 1);
	} else if ($.type(fobid) === 'boolean'){
		return fobid? 1 : 0;
	}
}

/**
 * 自动将form表单封装成json对象
 */
$.fn.serializeFormToJson = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};




/**
 * 图片格式判断
 * @param ext
 * @returns
 */
function isAssetTypeAnImage(ext) {
	return [ 'png', 'jpg', 'jpeg', 'bmp', 'gif', 'webp', 'psd', 'svg', 'tiff' ]
			.indexOf(ext.toLowerCase()) !== -1;
}
/**
 * 校验图片格式
 * @param fileName
 * @returns
 */
function checkFileTypeImg(fileName) {
	//获取最后一个.的位置
	var index= fileName.lastIndexOf(".");
	//获取后缀
	var ext = fileName.substr(index+1);
	//判断是否是图片
	return isAssetTypeAnImage(ext);
}


