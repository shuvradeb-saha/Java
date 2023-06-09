package model;

public class Media {
  private Integer owner;
  private String mediaId;

  public Media(Integer owner, String mediaId) {
    this.owner = owner;
    this.mediaId = mediaId;
  }

  public Integer getOwner() {
    return owner;
  }

  public void setOwner(Integer owner) {
    this.owner = owner;
  }

  public String getMediaId() {
    return mediaId;
  }

  public void setMediaId(String mediaId) {
    this.mediaId = mediaId;
  }

  @Override
  public String toString() {
    return "Media{" + "owner=" + owner + ", mediaId='" + mediaId + '\'' + '}';
  }
}
