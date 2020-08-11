package net.fkm.android3dtagview.model;

/**
 * 3d星球用户数据模型
 */
public class StarModel {

    // 用户昵称
    private String nickName;
    // 用户id
    private String userId;
    // 用户头像
    private String photoUrl;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
