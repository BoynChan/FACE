
/**
 * 缩略图预览
 * @param file
 * @param container
 */
var preview = function(file, container){
    //缩略图类定义
    var Picture  = function(file, container){
        var height = 0,
            width  = 0,
            ext    = '',
            size   = 0,
            name   = '',
            path   =  '';
        var self   = this;
        if(file){
            name = file.value;
            if(window.navigator.userAgent.indexOf("MSIE")>=1){
                file.select();
                path = document.selection.createRange().text;
            }else {
                if(file.files){
                    // path =  file.files.item(0).getAsDataURL(); // firefox7.0之后该方法弃用了，用下面那个
                    path = window.URL.createObjectURL(file.files[0]);
                }else{
                    path = file.value;
                }
            }
        }else{
            throw '无效的文件';
        }
        ext = name.substr(name.lastIndexOf("."), name.length);
        if(container.tagName.toLowerCase() != 'img'){
            throw '不是一个有效的图片容器';
            container.visibility = 'hidden';
        }
        container.src = path;
        container.alt = name;
        container.style.visibility = 'visible';
        height = container.height;
        width  = container.width;
        size   = container.fileSize;
        this.get = function(name){
            return self[name];
        };
        this.isValid = function(){
            if(allowExt.indexOf(self.ext) !== -1){
                throw '不允许上传该文件类型';
                return false;
            }
        }
    };

    try{
        var pic =  new Picture(file, document.getElementById('' + container));
    }catch(e){
        alert(e);
    }
};