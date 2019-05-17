package priv.starfish.web.dto;


import lombok.ToString;

@ToString
public final class QiNiuPutRet {
    public String key;
    public String hash;
    public String bucket;
    public int width;
    public int height;

}
