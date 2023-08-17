package cn.binarywang.wx.miniapp.api.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaVodService;
import cn.binarywang.wx.miniapp.bean.WxMaBaseResponse;
import cn.binarywang.wx.miniapp.bean.vod.*;
import cn.binarywang.wx.miniapp.json.WxMaGsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.enums.WxType;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.json.GsonParser;

import java.util.List;

import static cn.binarywang.wx.miniapp.constant.WxMaApiUrlConstants.Vod.*;


@RequiredArgsConstructor
@Slf4j
public class WxMaVodServiceImpl implements WxMaVodService {

  private final WxMaService service;

  @Override
  public List<WxMaVodMediaInfo> listMedia(WxMaVodListMediaRequest mediaRequest) throws WxErrorException {
    String responseContent = this.service.post(LIST_MEDIA_URL, mediaRequest.toJson());

    JsonObject jsonObject = GsonParser.parse(responseContent);
    boolean hasMediaInfoList = jsonObject.has("media_info_list");
    if (hasMediaInfoList) {
      return WxMaGsonBuilder.create().fromJson(jsonObject.getAsJsonArray("media_info_list"),
        new TypeToken<List<WxMaVodMediaInfo>>() {
        }.getType());
    } else {
      return null;
    }
  }


  @Override
  public List<WxMaVodDramaInfo> listDrama(WxMaVodListDramaRequest mediaRequest) throws WxErrorException {
    String responseContent = this.service.post(LIST_DRAMAS_URL, mediaRequest.toJson());
    JsonObject jsonObject = GsonParser.parse(responseContent);
    boolean hasMediaInfoList = jsonObject.has("drama_info_list");
    if (hasMediaInfoList) {
      return WxMaGsonBuilder.create().fromJson(jsonObject.getAsJsonArray("drama_info_list"),
        new TypeToken<List<WxMaVodDramaInfo>>() {
        }.getType());
    } else {
      return null;
    }
  }


  @Override
  public WxMaVodMediaPlaybackInfo getMediaLink(WxMaVodGetMediaLinkRequest request) throws WxErrorException {
    String responseContent = this.service.post(GET_MEDIA_LINK_URL, request.toJson());
    WxMaVodGetMediaLinkResponse getDetailResponse = WxMaGsonBuilder.create()
      .fromJson(responseContent, WxMaVodGetMediaLinkResponse.class);

    if (getDetailResponse.getErrcode() != 0) {
      throw new WxErrorException(WxError.fromJson(responseContent, WxType.MiniApp));
    }
    return getDetailResponse.getMediaInfo();
  }


  @Override
  public WxMaVodMediaInfo getMedia(WxMaVodGetMediaRequest request) throws WxErrorException {
    String responseContent = this.service.post(GET_MEDIA_URL, request.toJson());
    WxMaVodGetMediaResponse getDetailResponse = WxMaGsonBuilder.create()
      .fromJson(responseContent, WxMaVodGetMediaResponse.class);

    if (getDetailResponse.getErrcode() != 0) {
      throw new WxErrorException(WxError.fromJson(responseContent, WxType.MiniApp));
    }
    return getDetailResponse.getMediaInfo();
  }

  @Override
  public boolean deleteMedia(WxMaVodDeleteMediaRequest request) throws WxErrorException {
    String responseContent = this.service.post(DELETE_MEDIA_URL, request.toJson());
    WxMaBaseResponse getDetailResponse = WxMaGsonBuilder.create()
      .fromJson(responseContent, WxMaBaseResponse.class);

    if (getDetailResponse.getErrcode() != 0) {
      throw new WxErrorException(
        new WxError(getDetailResponse.getErrcode(), getDetailResponse.getErrmsg()));
    }

    return true;
  }

  @Override
  public WxMaVodDramaInfo getDrama(WxMaVodGetDramaRequest request) throws WxErrorException {
    String responseContent = this.service.post(GET_DRAMA_URL, request.toJson());
    WxMaVodGetDramaResponse getDetailResponse = WxMaGsonBuilder.create()
      .fromJson(responseContent, WxMaVodGetDramaResponse.class);

    if (getDetailResponse.getErrcode() != 0) {
      throw new WxErrorException(
        new WxError(getDetailResponse.getErrcode(), getDetailResponse.getErrmsg()));
    }

    return getDetailResponse.getDramaInfo();

  }

  @Override
  public Integer auditDrama(WxMaVodAuditDramaRequest request) throws WxErrorException {
    String responseContent = this.service.post(AUDIT_DRAMA_URL, request.toJson());
    WxMaVodAuditDramaResponse getDetailResponse = WxMaGsonBuilder.create()
      .fromJson(responseContent, WxMaVodAuditDramaResponse.class);

    if (getDetailResponse.getErrcode() != 0) {
      throw new WxErrorException(
        new WxError(getDetailResponse.getErrcode(), getDetailResponse.getErrmsg()));
    }

    return getDetailResponse.getDramaId();

  }
}
