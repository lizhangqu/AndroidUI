package cn.edu.zafu.expand;

/**
 * Created by Administrator on 2014/12/31.
 */
public class ChildItem {
    private int resId;
    private String name;
    private String detail;

    public ChildItem(int resId, String name, String detail) {
        this.resId = resId;
        this.name = name;
        this.detail = detail;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
