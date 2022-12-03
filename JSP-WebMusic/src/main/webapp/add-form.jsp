<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="./index.css" />
        <link rel="stylesheet" href="./add-form2.css" />
    </head>
    <body>
        <div class="add-form-container">
            <form action="" class="add-form">
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
                    <div class="add-form-input-main-info">
                        <div class="add-form-input-container">
                            <h2 class="add-form-input-title">Song</h2>
                            <input
                                type="text"
                                class="add-form-input"
                                placeholder="Song"
                            />
                        </div>

                        <div class="add-form-input-container">
                            <h2 class="add-form-input-title">Author</h2>
                            <input
                                type="text"
                                class="add-form-input"
                                placeholder="Author"
                            />
                        </div>
                    </div>
                    <div class="add-form-input-container">
                        <h2 class="add-form-input-title">Singer</h2>
                        <input
                            type="text"
                            class="add-form-input"
                            placeholder="Singer"
                        />
                    </div>

                    <div class="add-form-input-main-info">
                        <div class="add-form-input-container">
                            <h2 class="add-form-input-title">File song</h2>
                            <input type="file" class="add-form-input-file" />
                        </div>

                        <div class="add-form-input-container">
                            <h2 class="add-form-input-title">File image</h2>
                            <input type="file" class="add-form-input-file" />
                        </div>
                    </div>

                    <div class="add-form-input-container">
                        <h2 class="add-form-input-title">Lyrics</h2>
                        <textarea
                            type="text"
                            class="add-form-input"
                            placeholder="Lyrics"
                            aria-setsize="off"
                        ></textarea>
                    </div>
                </div>
                <div class="add-form-footer">
                    <button class="add-form-submit">Create</button>
                </div>
            </form>
        </div>
    </body>
</html>
