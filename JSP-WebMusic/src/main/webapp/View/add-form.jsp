<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="../app.css" />
        <style>
            .add-form-container {
                display: flex;
                width: 100%;
                justify-content: center;
                padding-top: calc(3 * var(--spacing-lg));
                font-size: var(--font-s-md);
                color: var(--contrast-color);
            }

            .add-form {
                position: relative;
                display: flex;
                width: 500px;
                flex-direction: column;
                gap: var(--spacing-lg-2);
                justify-content: center;
                padding: var(--spacing-md);
                padding-top: calc(2 * var(--spacing-lg));
                background-color: var(--primary-transparent-color);
                border-radius: var(--b-r-md);
            }

            .add-form-wrapper-image {
                width: 100%;
                display: flex;
                justify-content: center;
            }

            .add-form-container-logo {
                --size-logo: 150px;
                width: var(--size-logo);
                height: var(--size-logo);
                position: absolute;
                top: calc(-2.4 * var(--spacing-lg));
                background-color: var(--black);
                border-radius: var(--b-r-mch);
                padding: var(--spacing-sm);
            }

            .add-form-img {
                width: 100%;
                object-fit: cover;
            }

            .add-form-body {
                display: flex;
                flex-direction: column;
                gap: var(--spacing-lg);
            }

            .add-form-input-main-info {
                display: flex;
                gap: var(--spacing-md);
            }

            .add-form-input-container {
                flex: 1;
            }

            .add-form-input-title {
                font-weight: 500;
                font-size: var(--font-s-lg);
                margin-bottom: var(--spacing-sm);
            }

            .add-form-input {
                width: 100%;
                padding:  var(--spacing-sm);
                background-color: var(--sub-color);
                border-radius: var(--b-r-md);
                color: var(--contrast-color);
                font-size: var(--font-s-md);
                border: 1px solid transparent;
            }

            .add-form-input:focus {
                border: 1px solid var(--primary-color);
            }

            .add-form-footer {
                flex: 1;
                display: flex;
                justify-content: center;
            }

            .add-form-submit {
                width: 200px;
                background-color: var(--primary-color);
                padding: var(--spacing-sm);
                font-size: var(--font-s-md);
                color: var(--contrast-color);
                border-radius: var(--b-r-mch);
                border: none;
                transition: background-color 0.2s linear;
            }

            .add-form-submit:hover {
                background-color: var(--primary-dark-color);
            }

            textarea {
                resize: none;
                height: 100px;
                outline: none;
            }

            .add-form-input-file {
                width: 200px;
                cursor: pointer;
            }

        </style>
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
