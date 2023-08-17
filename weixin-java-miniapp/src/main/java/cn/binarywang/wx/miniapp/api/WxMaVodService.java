package cn.binarywang.wx.miniapp.api;

import cn.binarywang.wx.miniapp.bean.vod.*;
import me.chanjar.weixin.common.error.WxErrorException;

import java.util.List;

public interface WxMaVodService {
  List<WxMaVodMediaInfo> listMedia(WxMaVodListMediaRequest request) throws WxErrorException;

  List<WxMaVodDramaInfo> listDrama(WxMaVodListDramaRequest request) throws WxErrorException;

  WxMaVodMediaPlaybackInfo getMediaLink(WxMaVodGetMediaLinkRequest request) throws WxErrorException;

  WxMaVodMediaInfo getMedia(WxMaVodGetMediaRequest request) throws WxErrorException;

  boolean deleteMedia(WxMaVodDeleteMediaRequest request) throws WxErrorException;

  WxMaVodDramaInfo getDrama(WxMaVodGetDramaRequest request) throws WxErrorException;

  Integer auditDrama(WxMaVodAuditDramaRequest request) throws WxErrorException;

}
