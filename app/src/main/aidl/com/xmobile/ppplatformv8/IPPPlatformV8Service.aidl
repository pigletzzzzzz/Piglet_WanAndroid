// IPPPlatformV8Service.aidl
package com.xmobile.ppplatformv8;

// Declare any non-default types here with import statements

interface IPPPlatformV8Service {
/***
* 跳转到插件
*/
    boolean jump(String packagename);
  /***
  *获取当前位置信息，为了方便，返回的是json
   */
   String  getLocationData();

   /***
   *用于测试通讯，可以看到服务端一些信息,
   *只要这个函数可以使用，就表示aidl调通了。
   */
   String test();

    /***
      *播放视频
      */
  boolean play(String uri,String title);
}
