<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<spring:url value="/css/skel-noscript.css" var="css__skel_noscript" />
<spring:url value="/css/style.css" var="css__style" />
<spring:url value="/css/style-desktop.css" var="css__style_desktop" />
<spring:url value="/css/style-wide.css" var="css__style_wide" />
<!--
Striped 2.0 by HTML5 UP
html5up.net | @n33co
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Striped by HTML5 UP</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400italic,700|Open+Sans+Condensed:300,700" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/config.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/skel-panels.min.js"></script>
    <style type="text/css" title="currentStyle">
        @import "${css__skel_noscript}";
        @import "${css__style}";
        @import "${css__style_desktop}";
        @import "${css__style_wide}";
    </style>
    <!--[if lte IE 9]><link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie9.css" /><![endif]-->
    <!--[if lte IE 8]><script src="${pageContext.request.contextPath}/js/html5shiv.js"></script><link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie8.css" /><![endif]-->
    <!--[if lte IE 7]><link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie7.css" /><![endif]-->
</head>
<!--
    Note: Set the body element's class to "left-sidebar" to position the sidebar on the left.
    Set it to "right-sidebar" to, you guessed it, position it on the right.
-->
<body class="left-sidebar">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Content -->
    <div id="content">
        <div id="content-inner">
            <c:forEach items="${userEntries}" var="entries" varStatus="status">

                <article class="is-post is-post-excerpt">
                    <header>
                        <h2><a href="${pageContext.request.contextPath}/consulta/entrada/${entries.user.userAlias}/${entries.title}/${entries.id}">${entries.title}</a></h2>
                        <div style="float: left"><img src="${pageContext.request.contextPath}/consulta/imagen/usuario/perfil/60/60/${entries.user.id}" alt="" /></div>
                        <span class="byline">${entries.title}</span>
                        <a href="#PerfilDeUsuario">${entries.user.name}</a>: <span class="date">${entries.publicationDate}</span>
                    </header>
                    <p>${entries.content}</p>

                    <div class="info">
                        <span class="date"><span class="month">Jan<span>uary</span></span> <span class="day">8</span><span class="year">, 2013</span></span>
                        <ul class="stats">
                            <li><a href="#" class="link-icon24 link-icon24-1">12</a></li>
                            <li><a href="#" class="link-icon24 link-icon24-2">24</a></li>
                            <li><a href="#" class="link-icon24 link-icon24-3">48</a></li>
                            <li><a href="#" class="link-icon24 link-icon24-4">96</a></li>
                        </ul>
                    </div>
                </article>

            </c:forEach>

            <!-- Pager -->
            <div class="pager">
                <!--<a href="#" class="button previous">Previous Page</a>-->
                <div class="pages">
                    <a href="#" class="active">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <span>&hellip;</span>
                    <a href="#">20</a>
                </div>
                <a href="#" class="button next">Next Page</a>
            </div>

        </div>
    </div>

    <!-- Sidebar -->
    <div id="sidebar">

        <!-- Logo -->
        <div id="logo">
            <h1>STRIPED</h1>
        </div>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <li class="current_page_item"><a href="#">Latest Post</a></li>
                <li><a href="#">Archives</a></li>
                <li><a href="#">About Me</a></li>
                <li><a href="#">Contact Me</a></li>
            </ul>
        </nav>

        <!-- Search -->
        <section class="is-search">
            <form method="post" action="#">
                <input type="text" class="text" name="search" placeholder="Search" />
            </form>
        </section>

        <!-- Text -->
        <section class="is-text-style1">
            <div class="inner">
                <p>
                    <strong>Striped:</strong> A free and fully responsive HTML5 site
                    template designed by <a href="http://n33.co/">AJ</a> for <a href="http://html5up.net/">HTML5 up!</a>
                </p>
            </div>
        </section>

        <!-- Recent Posts -->
        <section class="is-recent-posts">
            <header>
                <h2>Recent Posts</h2>
            </header>
            <ul>
                <li><a href="#">Nothing happened</a></li>
                <li><a href="#">My Dearest Cthulhu</a></li>
                <li><a href="#">The Meme Meme</a></li>
                <li><a href="#">Now Full Cyborg</a></li>
                <li><a href="#">Temporal Flux</a></li>
            </ul>
        </section>

        <!-- Recent Comments -->
        <section class="is-recent-comments">
            <header>
                <h2>Recent Comments</h2>
            </header>
            <ul>
                <li>case on <a href="#">Now Full Cyborg</a></li>
                <li>molly on <a href="#">Untitled Post</a></li>
                <li>case on <a href="#">Temporal Flux</a></li>
            </ul>
        </section>

        <!-- Calendar -->
        <section class="is-calendar">
            <div class="inner">
                <table>
                    <caption>February 2013</caption>
                    <thead>
                    <tr>
                        <th scope="col" title="Monday">M</th>
                        <th scope="col" title="Tuesday">T</th>
                        <th scope="col" title="Wednesday">W</th>
                        <th scope="col" title="Thursday">T</th>
                        <th scope="col" title="Friday">F</th>
                        <th scope="col" title="Saturday">S</th>
                        <th scope="col" title="Sunday">S</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td colspan="4" class="pad"><span>&nbsp;</span></td>
                        <td><span>1</span></td>
                        <td><span>2</span></td>
                        <td><span>3</span></td>
                    </tr>
                    <tr>
                        <td><span>4</span></td>
                        <td><span>5</span></td>
                        <td><a href="#">6</a></td>
                        <td><span>7</span></td>
                        <td><span>8</span></td>
                        <td><span>9</span></td>
                        <td><a href="#">10</a></td>
                    </tr>
                    <tr>
                        <td><span>11</span></td>
                        <td><span>12</span></td>
                        <td><span>13</span></td>
                        <td class="today"><a href="#">14</a></td>
                        <td><span>15</span></td>
                        <td><span>16</span></td>
                        <td><span>17</span></td>
                    </tr>
                    <tr>
                        <td><span>18</span></td>
                        <td><span>19</span></td>
                        <td><span>20</span></td>
                        <td><span>21</span></td>
                        <td><span>22</span></td>
                        <td><a href="#">23</a></td>
                        <td><span>24</span></td>
                    </tr>
                    <tr>
                        <td><a href="#">25</a></td>
                        <td><span>26</span></td>
                        <td><span>27</span></td>
                        <td><span>28</span></td>
                        <td class="pad" colspan="3"><span>&nbsp;</span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </section>

        <!-- Copyright -->
        <div id="copyright">
            <p>
                &copy; 2013 An Untitled Site.<br />
                Images: <a href="http://n33.co">n33</a>, <a href="http://fotogrph.com">fotogrph</a>, <a href="http://iconify.it">Iconify.it</a>
                Design: <a href="http://html5up.net/">HTML5 UP</a>
            </p>
        </div>

    </div>

</div>

</body>
</html>