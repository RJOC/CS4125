<?php include('config.php'); ?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dance Manager Studio</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/payFunction.js"></script>
    <script src="https://js.stripe.com/v3/"></script>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet">
    <link href="css/styleCal.css" rel="stylesheet">
    <link href="css/payment.css" rel="stylesheet">
    <style>
        .centered {
            position: absolute;
            top: 90%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
            color: white;
            font-size: 200%;
            padding: 25px;
        }
    </style>


</head>

<body>
    <!-- Navigation -->
    <div id="navigation">
        <nav class="navbar navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="row">
                    <div class="site-logo">
                        <a href="userAccount.php" class="brand">Dance Manager Studio</a>
                    </div>

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="#home">Home</a></li>
                            <li><a href="userAccount.php">View Classes</a></li>
                            <li><a href="#payments">Payments</a></li>
                            <li><a href="#contact">Contact</a></li>
                            <li><a href="index.php">Log Out</a></li>
                        </ul>
                    </div>
                    <!-- /.Navbar-collapse -->
                </div>
            </div>
            <!-- /.container -->
        </nav>
    </div>
    <!-- /Navigation -->

    <div id="home">
        <div class="slider">
            <img src="img/dance_main.jpg" class="img-responsive" style="opacity:70%" />
            <div class="container">
                <div class="centered">Welcome to Dance Manager Studio. Work smarter and not harder!</div>
            </div>
        </div>
    </div>

    <!-- Make Payments -->
    <div id="view-payments">
        <section id="view-payments" style="background-image:url('img/dance_revolution.jpg'); background-repeat:no-repeat;background-size: 100% 100%;opacity:100%" class="home-section color-dark bg-white">
            <form action="payments.php" method="post" id="payment-form">
                <div class="form-row">
                    <label for="card-element">
                        Pay for class below:
                    </label>
                    <div id="card-element">
                        <script>
                            // Create a Stripe client.
                            var stripe = Stripe('pk_test_TYooMQauvdEDq54NiTphI7jx');

                            // Create an instance of Elements.
                            var elements = stripe.elements();

                            // Custom styling can be passed to options when creating an Element.
                            // (Note that this demo uses a wider set of styles than the guide below.)
                            var style = {
                                base: {
                                    color: '#32325d',
                                    fontFamily: '"Helvetica Neue", Helvetica, sans-serif',
                                    fontSmoothing: 'antialiased',
                                    fontSize: '16px',
                                    '::placeholder': {
                                        color: '#aab7c4'
                                    }
                                },
                                invalid: {
                                    color: '#fa755a',
                                    iconColor: '#fa755a'
                                }
                            };

                            // Create an instance of the card Element.
                            var card = elements.create('card', {
                                style: style
                            });

                            // Add an instance of the card Element into the `card-element` <div>.
                            card.mount('#card-element');

                            // Handle real-time validation errors from the card Element.
                            card.on('change', function(event) {
                                var displayError = document.getElementById('card-errors');
                                if (event.error) {
                                    displayError.textContent = event.error.message;
                                } else {
                                    displayError.textContent = '';
                                }
                            });

                            // Handle form submission.
                            var form = document.getElementById('payment-form');
                            form.addEventListener('submit', function(event) {
                                event.preventDefault();

                                stripe.createToken(card).then(function(result) {
                                    if (result.error) {
                                        // Inform the user if there was an error.
                                        var errorElement = document.getElementById('card-errors');
                                        errorElement.textContent = result.error.message;
                                    } else {
                                        // Send the token to your server.
                                        stripeTokenHandler(result.token);
                                    }
                                });
                            });

                            // Submit the form with the token ID.
                            function stripeTokenHandler(token) {
                                // Insert the token ID into the form so it gets submitted to the server
                                var form = document.getElementById('payment-form');
                                var hiddenInput = document.createElement('input');
                                hiddenInput.setAttribute('type', 'hidden');
                                hiddenInput.setAttribute('name', 'stripeToken');
                                hiddenInput.setAttribute('value', token.id);
                                form.appendChild(hiddenInput);

                                // Submit the form
                                form.submit();
                            }
                        </script>
                    </div>

                    <!-- Used to display form errors. -->
                    <div id="card-errors" role="alert"></div>
                </div>

                <button type="submit" name="login_btn" class="btn btn-success btn-block">Submit Payment</button>
            </form>

        </section>
    </div>
    <!-- /Make Payments -->


    <!-- Section: about -->
    <div id="make-payment">
        <section id="make-payment">
            <table>
                <tr>
                    <th>Amount Paid</th>
                    <th>Payment Date</th>
                </tr>
                <?php
                $conn = mysqli_connect("localhost", "root", "", "dance");
                // Check connection
                if ($conn->connect_error) {
                    die("Connection failed: " . $conn->connect_error);
                }
                $sql = "SELECT payment, date FROM payments";
                $result = $conn->query($sql);
                if ($result->num_rows > 0) {
                    // output data of each row
                    while ($row = $result->fetch_assoc()) {
                        echo "<tr><td>" . $row["payment"] . "</td><td>" . $row["date"] . "</td><td>";
                    }
                    echo "</table>";
                } else {
                    echo "0 results";
                }
                $conn->close();
                ?>
            </table>
        </section>
    </div>
    <!-- /Section: about -->


    <!-- Section: works -->
    <section id="works">
        <div class="container marginbot-50">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.1s">
                        <div class="section-heading text-center">
                            <h2 class="h-bold">Find us</h2>
                            <div class="divider-header"></div>
                            <p>Find us on all the social medias dancers!</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.8s">
                        <div class="service-icon">
                            <span class="fa fa-twitter fa-5x"></span>
                        </div>
                        <a href="https://www.twitter.com">
                            <h2>Twitter</h2>
                        </a>
                        <p>Tweet! Tweet!</p>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="wow flipInY" data-wow-offset="0" data-wow-delay="1.2s">
                        <div class="service-icon">
                            <span class="fa fa-facebook fa-5x"></span>
                        </div>
                        <a href="https://www.facebook.com">
                            <h2>Facebook</h2>
                        </a>
                        <p>Give our dancing a poke!</p>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="wow flipInY" data-wow-offset="0" data-wow-delay="1.6s">
                        <div class="service-icon">
                            <span class="fa fa-instagram fa-5x"></span>
                        </div>
                        <a href="https://www.instagram.com">
                            <h2>Instagram</h2>
                        </a>
                        <p>Feeling cute might delete this later ;)</p>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- /Section: works -->

    <!-- Section: contact -->
    <div id="contact">
        <div class="container marginbot-50">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.1s">
                        <div class="section-heading text-center">
                            <h2 class="h-bold">Contact Us</h2>
                            <div class="divider-header"></div>
                            <p>Send us your feedback!</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row contact-wrap">
                <div class="col-md-8 col-md-offset-2">
                    <div id="sendmessage">Your message has been sent. Thank you!</div>
                    <div id="errormessage"></div>
                    <form action="" method="post" role="form" class="contactForm">

                        <div class="form-group">
                            <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                            <div class="validation"></div>
                        </div>

                        <div class="form-group">
                            <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                            <div class="validation"></div>
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                            <div class="validation"></div>
                        </div>

                        <div class="form-group">
                            <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
                            <div class="validation"></div>
                        </div>

                        <div class="text-center"><button type="submit" class="btn btn-primary btn-lg">Send Message</button></div>

                    </form>
                </div>
            </div>
        </div>

    </div>
    <!-- /Section: contact -->

    <div class="map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d19352.660370711972!2d-8.57586525!3d52.67654715!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sie!4v1551097298215" width="100%" height="380" frameborder="0" style="border:0" allowfullscreen></iframe>
    </div>

    <!-- Section: footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="text-center">
                        <a href="#home" class="scrollup"><i class="fa fa-angle-up fa-3x"></i></a>
                        <p>&copy;Copyright - Dance Manager. All Rights Reserved</p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- /Section: footer -->

    <!-- Core JavaScript Files -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/functions.js"></script>
    <script src="contactform/contactform.js"></script>
    <script type="text/javascript" src="assets/js/display_profile_image.js"></script>

</body>

</html>