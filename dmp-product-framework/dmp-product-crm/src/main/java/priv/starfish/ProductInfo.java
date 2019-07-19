package priv.starfish;


/**
 * @author: jiahaixin
 * @date: 2019/2/11 17:25
 * @description: hadoop获取的商品信息数据
 */

public class ProductInfo {

    public String uid;

    public String pid;
    public String pName;
    public String clickUrl;
    public String imgUrl;
    public String imgUrl1;
    public String imgUrl2;
    public String imgUrl3;
    public String price;
    public String category;
    public String subCategory;
    public String thirdCategory;
    public String androidDplink;
    public String iosDplink;
    public String targetUrl;
    public String mClickUrl;
    public String title;
    public String availability;
    public String inventoryNum;
    public String lproperty;
    public String sellerSiteUrl;
    public String bName;
    public String label;

    public String hashId;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"uid\":\"")
                .append(uid).append('\"');
        sb.append(",\"pid\":\"")
                .append(pid).append('\"');
        sb.append(",\"pName\":\"")
                .append(pName).append('\"');
        sb.append(",\"clickUrl\":\"")
                .append(clickUrl).append('\"');
        sb.append(",\"imgUrl\":\"")
                .append(imgUrl).append('\"');
        sb.append(",\"imgUrl1\":\"")
                .append(imgUrl1).append('\"');
        sb.append(",\"imgUrl2\":\"")
                .append(imgUrl2).append('\"');
        sb.append(",\"imgUrl3\":\"")
                .append(imgUrl3).append('\"');
        sb.append(",\"price\":\"")
                .append(price).append('\"');
        sb.append(",\"category\":\"")
                .append(category).append('\"');
        sb.append(",\"subCategory\":\"")
                .append(subCategory).append('\"');
        sb.append(",\"thirdCategory\":\"")
                .append(thirdCategory).append('\"');
        sb.append(",\"androidDplink\":\"")
                .append(androidDplink).append('\"');
        sb.append(",\"iosDplink\":\"")
                .append(iosDplink).append('\"');
        sb.append(",\"targetUrl\":\"")
                .append(targetUrl).append('\"');
        sb.append(",\"mClickUrl\":\"")
                .append(mClickUrl).append('\"');
        sb.append(",\"title\":\"")
                .append(title).append('\"');
        sb.append(",\"availability\":\"")
                .append(availability).append('\"');
        sb.append(",\"inventoryNum\":\"")
                .append(inventoryNum).append('\"');
        sb.append(",\"lproperty\":\"")
                .append(lproperty).append('\"');
        sb.append(",\"sellerSiteUrl\":\"")
                .append(sellerSiteUrl).append('\"');
        sb.append(",\"bName\":\"")
                .append(bName).append('\"');
        sb.append(",\"label\":\"")
                .append(label).append('\"');
        sb.append(",\"hashId\":\"")
                .append(hashId).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getThirdCategory() {
        return thirdCategory;
    }

    public void setThirdCategory(String thirdCategory) {
        this.thirdCategory = thirdCategory;
    }

    public String getAndroidDplink() {
        return androidDplink;
    }

    public void setAndroidDplink(String androidDplink) {
        this.androidDplink = androidDplink;
    }

    public String getIosDplink() {
        return iosDplink;
    }

    public void setIosDplink(String iosDplink) {
        this.iosDplink = iosDplink;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getmClickUrl() {
        return mClickUrl;
    }

    public void setmClickUrl(String mClickUrl) {
        this.mClickUrl = mClickUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(String inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public String getLproperty() {
        return lproperty;
    }

    public void setLproperty(String lproperty) {
        this.lproperty = lproperty;
    }

    public String getSellerSiteUrl() {
        return sellerSiteUrl;
    }

    public void setSellerSiteUrl(String sellerSiteUrl) {
        this.sellerSiteUrl = sellerSiteUrl;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }
}
