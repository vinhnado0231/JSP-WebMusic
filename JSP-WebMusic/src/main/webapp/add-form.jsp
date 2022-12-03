<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="./index.css" />
        <link rel="stylesheet" href="./add-form2.css" />
    </head>
    <body>
        <div class="add-form-container">
            <form action="PlaylistServlet?action=addPlaylist" class="add-form">
                <h2 class="add-form-title">Create playlist</h2>

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
                        />
                    </div>

                    <div class="add-form-input-container">
                        <h2 class="add-form-input-title">Image</h2>
                        <input type="file" class="add-form-input-file" />
                    </div>
                </div>
                <div class="add-form-footer">
                    <button class="add-form-submit">Create playlist</button>
                </div>
            </form>
        </div>
    </body>
</html>
