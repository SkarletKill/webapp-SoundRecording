<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by NeO
  Date: 07.05.2018
  Time: 20:46
--%>

<%@ page import="ua.kpi.tef.view.View" %>
<%@ page import="ua.kpi.tef.controller.Servlet" %>
<%@ page import="ua.kpi.tef.model.*" %>
<%@ page import="ua.kpi.tef.model.DB.entity.Disk" %>
<%@ page import="ua.kpi.tef.model.DB.dao.Database" %>
<%@ page import="java.util.Objects" %>
<%@ page import="ua.kpi.tef.model.DB.service.DiskTrackService" %>
<%@ page import="ua.kpi.tef.model.DB.entity.Track" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.kpi.tef.model.DB.entity.Genre" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sound Recording</title>
    <link rel="stylesheet" type="text/css" href="myStyle.css">
    <meta charset="UTF-8">
</head>
<body>
<h2>Hello Skarlet's recording studio!</h2>

<% Entity model = (Entity) session.getAttribute(View.model); %>

<div class="main-block grid-container-2half">
    <div class="disk-block">
        <div class="disk grid-container">
            <label><%= View.getLocaleMassage(View.DISK_TEXT) %>
            </label>
            <form action="servlet" method="post">
                <select name="<%=View.disksForDisk%>" onchange="this.parentElement.submit()">
                    <option value="0" selected disabled style="display: none"><%= View.getLocaleMassage(View.DISK_SELECT) %>
                    </option>
                    <% for(Disk disk: Objects.requireNonNull(Database.disksDao().getAll())){ %>
                        <% if(disk.getTitle().equals(model.getDisk().getTitle())) {%>
                        <%--<% if(request.getParameter("d-disks[]") != null && request.getParameter("d-disks[]").equals(disk.getTitle())) {%>--%>
                            <option selected value="<%= disk.getTitle() %>"><%= disk.getTitle() %></option>
                        <%} else {%>
                            <option value="<%= disk.getTitle() %>"><%= disk.getTitle() %></option>
                    <% }} %>
                </select>
            </form>
        </div>

        <div class="duration grid-container">
            <label><%= View.getLocaleMassage(View.DISK_DURATION_TEXT) %>
            </label>
            <form action="servlet" method="post" class="grid-container-2">
                <input type="text"
                       <% String attr = (String) request.getAttribute(View.diskDurationValue);%>
                       value='<%= (attr != null)? attr: "" %>'
                       name="<%=View.diskDuration%>" class="field"
                       placeholder="<%=View.getLocaleMassage(View.DISK_DURATION_PLACEHOLDER)%>" readonly/>
                <input type="submit" class="submit" value="<%=View.getLocaleMassage(View.DISK_DURATION_BUTTON)%>"
                       name="<%=View.diskCountButton%>">
            </form>
        </div>

        <div class="sort grid-container">
            <label><%= View.getLocaleMassage(View.DISK_SORT_TEXT) %>
            </label>
            <form method="post" action="servlet" class="grid-container-2">
                <select name="<%=View.diskGenres%>">
                    <option value="0" selected disabled style="display: none"><%= View.getLocaleMassage(View.DISK_SORT_SELECT) %>
                    </option>
                    <% for (Genre genre : Database.genresDao().getAll()) {%>
                        <option value="<%=genre.getName()%>"><%=genre.getName()%></option>
                    <% }%>
                </select>
                <input type="submit" class="submit" value="<%=View.getLocaleMassage(View.DISK_SORT_BUTTON)%>"
                       name="<%=View.diskSortButton%>">
            </form>
        </div>

        <div class="find grid-container">
            <label><%= View.getLocaleMassage(View.DISK_FIND_TEXT) %>
            </label>
            <form method="post" action="servlet" class="grid-container-2">
                <div>
                    <input type="text" value="" name="<%=View.diskFindFrom%>" class="field limited"
                           placeholder="<%=View.getLocaleMassage(View.DISK_FIND_FROM)%>"/>
                    <input type="text" value="" name="<%=View.diskFindTo%>" class="field limited"
                           placeholder="<%=View.getLocaleMassage(View.DISK_FIND_TO)%>"/>
                </div>
                <input type="submit" class="submit" value='<%=View.getLocaleMassage(View.DISK_FIND_BUTTON)%>'
                       name="<%=View.diskFindButton%>">
            </form>
        </div>

        <div class="list grid-container fix-content">
            <label><%= View.getLocaleMassage(View.DISK_TRACKLIST_TEXT) %>
            </label>
            <div class="tracklist">
                <% List<Track> trackList = model.getDiskTrackList(); %>
                <% if(request.getAttribute(View.diskFindFilter) != null) { %>
                    <% trackList = (TrackList) request.getAttribute(View.diskFindFilter); %>
                <% } %>
                <% for (Track track: trackList) { %>
                    <label value="<%=track%>"><%=track.getTitle()%></label>
                    <br>
                <% } %>
            </div>
            <div></div>
        </div>
    </div>
    <div class="playlist-block">
        <div class="playlist grid-container-pl-two">
            <label><%= View.getLocaleMassage(View.PLAYLIST_TEXT) %>:
                (<%= model.getTrackList().size()%>)</label>
            <form method="post" action="servlet" class="grid-container-2 gc-p2">
                <div></div>
                <select name="<%=View.language%>" onchange="this.parentElement.submit()">
                    <option value="0" selected disabled style="display: none"><%= View.getLocaleMassage(View.LANGUAGE_SELECT) %>
                    </option>
                    <option value="en">English</option>
                    <option value="ua">Українська</option>
                </select>
            </form>
        </div>
        <div class="track">
            <form action="servlet" method="post">
                <div class="title grid-container-pl-two">
                    <label><%= View.getLocaleMassage(View.PLAYLIST_SONG_TITLE) %></label>
                    <input type="text" value="" name="<%=View.songTitle%>" class="field" />
                </div>

                <div class="artist grid-container-pl-two">
                    <label><%= View.getLocaleMassage(View.PLAYLIST_SONG_ARTIST) %></label>
                    <input type="text" value="" name="<%=View.songArtist%>" class="field" />
                </div>

                <div class="genre grid-container-pl-two">
                    <label><%= View.getLocaleMassage(View.PLAYLIST_SONG_GENRE) %></label>
                    <select name="<%=View.songGenre%>">
                        <option value="0" selected disabled style="display: none"><%= View.getLocaleMassage(View.DISK_SORT_SELECT) %>
                        </option>
                        <% for (Genre genre : Database.genresDao().getAll()) {%>
                            <option value="<%=genre.getName()%>"><%=genre.getName()%></option>
                        <% }%>
                        <%--<c:forEach items="${MusicGenre.values()}" var="item">--%>
                            <%--<option value="${item.name().toLowerCase()}">${item.name()}</option>--%>
                        <%--</c:forEach>--%>
                    </select>
                </div>


                <div class="s-duration grid-container-pl-two">
                    <label><%= View.getLocaleMassage(View.PLAYLIST_SONG_DURATION) %></label>
                    <input type="text" value="" name="<%=View.songDuration%>" class="field" />
                </div>

                <div class="grid-container button-add">
                    <div></div>
                        <input type="submit" class="submit" value="<%=View.getLocaleMassage(View.PLAYLIST_BUTTON_ADD)%>"
                                name="<%=View.plButtonAdd%>">
                        <input type="submit" class="submit" value="<%=View.getLocaleMassage(View.PLAYLIST_BUTTON_CLEAR)%>"
                               name="<%=View.plButtonClear%>">
                </div>
            </form>
        </div>

        <div class="write grid-container gc-p">
            <label><%= View.getLocaleMassage(View.PLAYLIST_WRITE_TEXT) %> </label>
            <form action="servlet" method="post" class="grid-container-2 gc-p2">
                <select name="<%=View.disksForPl%>">
                    <option value="0" selected disabled style="display: none"><%= View.getLocaleMassage(View.DISK_SELECT) %>
                    </option>
                    <% for (Disk disk : Database.disksDao().getAll()) {%>
                        <option value="<%=disk.getTitle()%>"><%=disk.getTitle()%></option>
                    <% }%>
                    <%--<c:forEach items="${Disk.getDisks()}" var="disk">--%>
                        <%--<option value="disk.getTitle()}">${disk.getTitle()}</option>--%>
                    <%--</c:forEach>--%>
                </select>
                <input type="submit" class="submit" value="<%=View.getLocaleMassage(View.PLAYLIST_BUTTON_WRITE)%>"
                       name="<%=View.plWriteButton%>">
            </form>
        </div>

    </div>
</div>
</body>
</html>