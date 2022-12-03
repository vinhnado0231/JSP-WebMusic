<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="./index.css" />
        <link rel="stylesheet" href="./edit-form.css" />
    </head>
    <body>
<%--    <form action="PlaylistServlet">--%>
        <div class="add-form-container">
            <form action="PlaylistServlet?action=updatePlaylist&&updatePlaylist=<%= session.getAttribute("idUpdate") %> " method="post" class="add-form">
                <h2 class="add-form-title">Edit playlist</h2>

                <div class="add-form-wrapper-image">
                    <div class="add-form-container-logo">
                        <img
                                src="../Media/logo.png"
                                alt="logo"
                                class="add-form-img"
                        />
                    </div>
                </div>
                <div class="add-form-body">
                    <div class="add-form-input-container">
                        <h2 class="add-form-input-title">Name</h2>
                        <input
                                type="text"
                                class="add-form-input"
                                placeholder="Name"
                                name="txtUpdate"
                                value="<%=session.getAttribute("nameUpdate")%>"
                        />
                    </div>
                </div>
                <div class="add-form-footer">
                    <button type="submit" class="add-form-submit" name="updatePlaylist" value="<%= session.getAttribute("idUpdate") %>">Edit playlist</button>
                </div>
            </form>
        </div>
<%--    </form>--%>
    </body>
</html>
