package cn.binarywang.wx.miniapp.api.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.vod.*;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;

@Test
@Guice(modules = ApiTestModule.class)
public class WxMaVodServiceImplTest {
  @Inject
  private WxMaService wxService;

  @Test
  public void testListMedia() throws Exception {
    WxMaVodListMediaRequest request = WxMaVodListMediaRequest.builder()
      .dramaId(100000)
      .offset(0)
      .limit(100)
      .build();
    List<WxMaVodMediaInfo> response = this.wxService.getWxMaVodService().listMedia(request);
    assertNotNull(response);
  }

  @Test
  public void testListDrama() throws Exception {
    WxMaVodListDramaRequest request = WxMaVodListDramaRequest.builder()
      .offset(0)
      .limit(100)
      .build();
    List<WxMaVodDramaInfo> response = this.wxService.getWxMaVodService().listDrama(request);
    assertNotNull(response);

  }

  @Test
  public void testGetMediaLink() throws Exception {
    WxMaVodGetMediaLinkRequest request = WxMaVodGetMediaLinkRequest.builder()
      .mediaId(10000)
      .build();
    WxMaVodMediaPlaybackInfo response = this.wxService.getWxMaVodService().getMediaLink(request);
    assertNotNull(response);
  }

  @Test
  public void testGetMedia() throws Exception {
    WxMaVodGetMediaRequest request = WxMaVodGetMediaRequest.builder()
      .mediaId(0)
      .build();
    WxMaVodMediaInfo response = this.wxService.getWxMaVodService().getMedia(request);
    assertNotNull(response);
  }

  @Test
  public void testDeleteMedia() throws Exception {
    WxMaVodDeleteMediaRequest request = WxMaVodDeleteMediaRequest.builder()
      .mediaId(0)
      .build();
    boolean response = this.wxService.getWxMaVodService().deleteMedia(request);
    assertNotNull(response);
  }

  @Test
  public void testGetDrama() throws Exception {
    WxMaVodGetDramaRequest request = WxMaVodGetDramaRequest.builder()
      .dramaId(0)
      .build();
    WxMaVodDramaInfo response = this.wxService.getWxMaVodService().getDrama(request);
    assertNotNull(response);
  }

  @Test
  public void testAuditDrama() throws Exception {
    WxMaVodAuditDramaRequest request = WxMaVodAuditDramaRequest.builder()
      .dramaId(0)
      .name("name")
      .build();
    Integer response = this.wxService.getWxMaVodService().auditDrama(request);
    assertNotNull(response);
  }
}
