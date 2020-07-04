package cn.coget.apps.supper;

/**
 * 业务异常
 *
 * author: sin
 * time: 2020/7/4 11:26 上午
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String msg) {
        super(msg);
    }
}
