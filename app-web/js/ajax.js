function ajax (options) {
  options = {
    url : options.url || '',
    method : options.method || 'POST',
    dataType : options.dataType || 'json',
    asyn : options.asyn || true,
    contentType: options.contentType || "application/x-www-form-urlencoded",
    timeout : options.timeout || 30000,
    success : options.success || function () {},
    error : options.error || function () {},
    complete : options.complete || function () {},
    onTimeout : options.onTimeout || function () {
      options.error(0, 0, "timeout");
      options.complete();
    },
    data : options.data || {},
    header: options.header || null,
  };
  var xhr = (function(){
    if (typeof XMLHttpRequest !== undefined) {
      return new XMLHttpRequest();
    } else {
      var versions = ['MS2XML.XMLHTTP.6.0', 'MS2XML.XMLHTTP.3.0', 'MS2XML.XMLHTTP', 'Microsoft.XMLHTTP'];
      for (var i = 0; i < versions.length; i++) {
        try {
          return new ActiveXObject(versions[i]);
        } catch (e) {
          continue;
        }
      }
    }
  })();
  xhr.onreadystatechange = function () {
    if (xhr && xhr.readyState === 4) {
      if ((200 <= xhr.status < 300)
      || (xhr.status === 304)
      || (!xhr.status && location.protocol === 'file:')
      || (window.userAgent.indexOf('Safari') !== -1 && typeof xhr.status === undefined)) {
        try {
          var contentType = xhr.getResponseHeader('Content-Type');
          var isXMLType = !options.dataType && contentType && contentType.indexOf('xml') >= 0;
          var data = (options.dataType.toLowerCase() === 'xml') || isXMLType ? xhr.responseXML : xhr.responseText;
          if (options.dataType.toLowerCase() === 'script') {
            eval.call(window, data);
          } else if(options.dataType.toLowerCase() === 'json') {
            data = JSON.parse(data);
          }
          options.success(data);
        } catch(e) {
          options.error(xhr.readyState, xhr.status, "解析失败");
        }
      } else {
        options.error(xhr.readyState, xhr.status, "请求失败");
      }
      xhr = null;
      options.complete();
    }
  };
  if (options.method.toLowerCase() === 'get') {
    options.url += options.url.indexOf('?') === -1 ? '?' : '&';
    options.url += typeof options.data === "object" ? serialize(options.data) : serialize({data: options.data});
  }
  options.url += (options.url.indexOf('?') === -1 ? '?' : '&') + "_=" + Date.now();
  xhr.open(options.method, options.url, options.asyn);
  xhr.timeout = options.timeout;
  xhr.ontimeout = options.onTimeout;
  xhr.setRequestHeader("Content-type", options.contentType);
  if(options.header) {
    for(var i in options.header) {
      xhr.setRequestHeader(i, options.header[i]);
    }
  }
  if(options.contentType == "application/json") {
    xhr.send(typeof options.data === "object" ? JSON.stringify(options.data) : options.data);
  } else if(options.method.toLowerCase() === 'post') {
    xhr.send(typeof options.data === "object" ? serialize(options.data) : options.data);
  } else {
    xhr.send(null);
  }
};

function serialize(data) {
  if(typeof data == "string") return data;
  var results = [];
  for (var key in data) {
    results.push(encodeURIComponent(key) + '=' + encodeURIComponent(data[key]));
  }
  return results.join('&');
}