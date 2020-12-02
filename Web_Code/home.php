<?php include('config.php') ?>
<?php include(INCLUDE_PATH . '/logic/userSignup.php'); ?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Mowie</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link href="css/animate.min.css" rel="stylesheet">
  <link href="css/animate.css" rel="stylesheet" />
  <link href="css/style.css" rel="stylesheet">

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
            <a href="index.html" class="brand">mowie</a>
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
              <li class="active"><a href="home.php">Home</a></li>
              <li><a href="personalprofile.php">Profile</a></li>
              <li><a href="search.php">Search</a></li>
              <li><a href="autoGenMatches.php">Suggestions</a></li>
              <li><a href="information.php">Information</a></li>
              <li><a href="logout.php">Logout</a></li>
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
      <img src="img/beardcouple.jpg" class="img-responsive" />
      <div class="container">
        <div class="centered">Welcome to Mowie! The #1 dating site for beard lovers and beard... ehhh havers!</div>
      </div>
    </div>
  </div>

  <section id="testamonies">
    <div class="container marginbot-50">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
          <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
            <div class="section-heading text-center">
              <h2 class="h-bold">Testamonies</h2>
              <div class="divider-header"></div>
              <p>Here's a few words from our satisfied customers!</p>
              <p>Join the millions of singles looking for love today!</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <div id="myCarousel" class="carousel slide" data-ride="carousel" style=" width:100%; height: 650px !important;">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <img src="img/test1.jpeg" alt="testamony1" style="width:100%; height: 650px">
            <div class="carousel-caption d-none d-md-block">
              <h3>Thomas, 28</h3>
              <p>It was so quick and easy to learn! I found my match in no time!</p>
            </div>
          </div>

          <div class="item">
            <img src="img/test2.jpeg" alt="testamony2" style="width:100%; height: 650px">
            <div class="carousel-caption d-none d-md-block">
              <h3>Andrea, 32</h3>
              <p>Thanks to Mowie I found the lumberjack man of my dreams!</p>
            </div>
          </div>

          <div class="item">
            <img src="img/test3.jpeg" alt="testamony3" style="width:100%; height: 650px">
            <div class="carousel-caption d-none d-md-block">
              <h3>Howard, 67</h3>
              <p>It's amazing to finaly meet someone that likes my stubbly greying face!</p>
            </div>
          </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>


    <!-- Section: about -->
    <section id="about">
      <div class="container marginbot-50">
        <div class="row">
          <div class="col-lg-8 col-lg-offset-2">
            <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.4s">
              <div class="section-heading text-center">
                <h2 class="h-bold">About Us</h2>
                <div class="divider-header"></div>
                <p>Mowie is the #1 website for beard growers and beard lovers</p>
                <p>Mowie was set up by a group of computer science students in 2019 for their college assignment!</p>
              </div>
            </div>
          </div>
        </div>
      </div>


    </section>
    <!-- /Section: about -->

    <!-- Section: services -->
    <section id="services" class="home-section color-dark bg-white">
      <div class="container marginbot-50">
        <div class="row">
          <div class="col-lg-8 col-lg-offset-2">
            <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.1s">
              <div class="section-heading text-center">
                <h2 class="h-bold">How to use</h2>
                <div class="divider-header"></div>
                <p>Check out this useful how to guide. It could "shave" you a couple of seconds... I'm sorry</p>
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
                <span class="glyphicon glyphicon-user fa-5x"></span>
              </div>
              <h2>Set Up Your New Account</h2>
              <p>Tell us a bit about yourself!</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="wow flipInY" data-wow-offset="0" data-wow-delay="1.2s">
              <div class="service-icon">
                <span class="fa fa-search fa-5x"></span>
              </div>
              <h2>Get Searching</h2>
              <p>Find your dream partner using our search preferences</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="wow flipInY" data-wow-offset="0" data-wow-delay="1.6s">
              <div class="service-icon">
                <span class="fa fa-heart fa-5x"></span>
              </div>
              <h2>Start Meeting Singles</h2>
              <p>You moustache them for drinks first</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Section: services -->

    <!-- Section: works -->
    <section id="works">
      <div class="container marginbot-50">
        <div class="row">
          <div class="col-lg-8 col-lg-offset-2">
            <div class="wow flipInY" data-wow-offset="0" data-wow-delay="0.1s">
              <div class="section-heading text-center">
                <h2 class="h-bold">Find us</h2>
                <div class="divider-header"></div>
                <p>Find us on all the social medias fuzz faces!</p>
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
              <p>Give our beards a poke!</p>
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
    <!-- Section: services -->


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
    <div class="map">
      <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d19352.660370711972!2d-8.57586525!3d52.67654715!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sie!4v1551097298215" width="100%" height="380" frameborder="0" style="border:0" allowfullscreen></iframe>
    </div>
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-offset-3">
            <div class="text-center">
              <a href="#home" class="scrollup"><i class="fa fa-angle-up fa-3x"></i></a>
              <p>&copy;Copyright - Mowie. All Rights Reserved</p>
            </div>
          </div>
        </div>
      </div>
    </footer>

    <!-- Core JavaScript Files -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/functions.js"></script>
    <script src="contactform/contactform.js"></script>

</body>

</html>