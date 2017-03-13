<%--
  Created by IntelliJ IDEA.
  User: vic
  Date: 2017/1/25
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="footer_container">
    <div id="footer">
        <div class="footer_top">
            <div class="footer_top_bg">
                <div id="footer_links">
                    <ul class="linksa">
                        <li class="links">使用帮助</li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">新手指南</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">常见问题</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">帮助中心首页</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">用户协议</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">隐私声明</a>
                        </li>
                    </ul>
                    <ul class="linksb">
                        <li class="links">售后服务</li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">100%正品保障</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">退换货政策</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">在线退货办理</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">玩转口碑中心</a>
                        </li>
                    </ul>
                    <ul class="linksc">
                        <li class="links">获取更新</li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">订阅每日团购</a>
                        </li>
                        <li>
                            <a href="#" target="_blank">小梁玩具博客</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">小梁玩具新浪微博</a>
                        </li>
                        <li>
                            <a href="#" target="_blank">小梁玩具手机版</a>
                        </li>
                    </ul>
                    <ul class="linksd">
                        <li class="links">关于小梁玩具</li>
                        <li>
                            <a href="#" target="_blank" style="font-weight:bold;" rel="nofollow">品牌合作专区</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">关于小梁玩具</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">媒体报道</a>
                        </li>
                    </ul>
                    <ul class="linkse">
                        <li class="links">加入小梁玩具</li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">商务合作</a>
                        </li>
                        <li>
                            <a href="#" target="_blank">招贤纳士</a>
                        </li>
                        <li>
                            <a href="#" target="_blank">友情链接</a>
                        </li>
                    </ul>
                    <ul class="linksf">
                        <li class="links">支付方式</li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">货到付款</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">在线支付</a>
                        </li>
                        <li>
                            <a href="#" target="_blank" rel="nofollow">余额支付</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer_top">
            <div class="footer_top_bg"></div>
        </div>
        <div id="footer_copyright">
            <p>© 2017 spring mvc + mybatis制作。Ω客服热线：123456789</p>
            <script>function change_urlknet(eleId) {
                var str = document.getElementById(eleId).href;
                var str1 = str.substring(0, (str.length - 6));
                str1 += RndNum(6);
                document.getElementById(eleId).href = str1;
            }
            function RndNum(k) {
                var rnd = "";
                for (var i = 0; i < k; i++) {
                    rnd += Math.floor(Math.random() * 10);
                }
                return rnd;
            }</script>

        </div>

    </div>
</div>
<style type="text/css">
    /* 首页footer加入友情链接 */
    .footer_friend_link {
        width: 940px;
        margin: 0 auto 20px;
        padding: 0 10px 20px;
        color: #808080;
    }

    .footer_friend_link .footer_firend_title {
        width: 60px;
        float: left;
    }

    .footer_friend_link .footer_firend_content {
        width: 720px;
        float: left;
        overflow: hidden;
        height: 16px;
        line-height: 16px;
    }

    .footer_friend_link .footer_firend_content ul {

        height: 16px;
    }

    .footer_friend_link .footer_firend_content li {
        float: left;
        overflow: hidden;
        width: 720px;
    }

    .footer_friend_link .footer_firend_content li a {
        color: #808080;
        padding: 0 5px;
    }

    .footer_friend_link .footer_firend_more {
        float: left;
        padding-left: 20px;
    }

    .footer_friend_link .footer_firend_more a {
        color: #808080;
        text-decoration: underline;
    }

    /* 首页footer加入友情链接 end */
</style>
<div style="display:inline;"><img height="1" width="1" style="border-style:none;" alt="" src="#"></div>
