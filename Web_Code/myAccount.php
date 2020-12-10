<!DOCTYPE html>
<html lang="en">
<?php
require 'accountfunctions.php';
accountLoggedIn();
banCheck();
?>


<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Dance School</title>

  <!-- Bootstrap core CSS -->
  <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="shortcut icon" href="img/logo.png">
  <!-- Custom fonts for this template -->
  <link href="./vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link rel="stylesheet" href="vendor/simple-line-icons/css/simple-line-icons.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">

  <!-- Plugin CSS -->
  <link rel="stylesheet" href="./device-mockups/device-mockups.min.css">

  <!-- Custom styles for this template -->
  <link href="./css/new-age.min.css" rel="stylesheet">
  <link href="./css/animate.min.css" rel="stylesheet">
  <script>
    function hide() {
      var x = document.getElementById("loginNav");
      if (loggedIn()) {
        x.addClass("hidden");
      } else {
        x.removeClass("hidden");
      }
    }
  </script>
</head>


<body style="background:  url(./img/bg-pattern.png),linear-gradient(to left,#7b4397,#dc2430);">

  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="index.php">BanderMatch </a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">

        <ul class="navbar-nav mr-auto">

          <?php
          if (!loggedIn()) {
          ?>
            <li class="nav-item" id="loginNav">
              <a class="nav-link" href="login.php">Login</a>
            </li>
          <?php
          }
          ?>
          <li class="nav-item">
            <a class="nav-link" href="register.php">Register</a>
          </li>
          <?php
          if (loggedIn()) {
          ?>
            <li class="nav-item">
              <a class="nav-link" href="findAMatch.php">Find-A-Match</a>
            </li>
          <?php
          }
          ?>
          <?php
          if (loggedIn()) {
          ?>
            <li class="nav-item">
              <a class="nav-link" href="matches.php">Matches</a>
            </li>
          <?php
          }
          ?>
          <li class="nav-item">
            <a class="nav-link" href="reviews.php">Reviews</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="FAQ.php">FAQs</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.php">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.php">Contact Us</a>
          </li>
          <?php
          if (loggedIn()) {
          ?>
            <li class="nav-item">
              <a class="nav-link" href="myAccount.php">My Account</a>
            </li>
          <?php
          }
          ?>
          <?php
          if (checkAdmin()) {
          ?>
            <li class="nav-item">
              <a class="nav-link" href="admin.php">Admin</a>
            </li>
          <?php
          }
          ?>
          <?php
          if (loggedIn()) {
          ?>
            <li class="nav-item">
              <a class="nav-link" href="logout.php">Logout</a>
            </li>
          <?php
          }
          ?>
          <?php
          if (loggedIn()) {
          ?>
            <li class="nav-item">
              <a class="nav-link" href="notifications.php"><img src="<?php echo (checkForNotifications(returnMemberID()) == TRUE ? 'img\Icons\notification.png' : 'img\Icons\notification2.png'); ?>" alt="" width="18" height="18"></a>
            </li>
          <?php
          }
          ?>
        </ul>
      </div>
    </div>
  </nav>



  <!-- Page Content -->
  <div class="container">

    <br>
    <br>
    <br>
    <br>

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3 text-white animated bounceInDown"><b><?php echo returnName(returnMemberID());
                                                              echo "'s profile"; ?></b></h1>

    <nav aria-label="breadcrumb">
      <ol class="breadcrumb bg-dark animated bounceInLeft">
        <li class="breadcrumb-item">
          <a href="index.php" class="text-light">Home</a>
        </li>
        <li class="breadcrumb-item active"> <?php echo returnName(returnMemberID());
                                            echo "'s profile"; ?></li>
      </ol>


      <!-- Page Heading/Breadcrumbs -->





      <!-- Content Row -->
      <?php
      myAccount(0, returnMemberID());
      if (isset($_POST['updateAccount'])) {
        updateAccount(0, returnMemberID());
      }
      ?>
      <?php
      if (isset($_POST['deleteAccount'])) {
        deleteAccount(returnMemberID(), 0);
      }
      ?>

      <br>
      <h3><b>Update Email & Password:</b></h3>
      <form action="myAccount.php" method="POST"><b>Current Email:</b><br />
        <label for="inputEmail" class="sr-only"><b>Current Email address</b></label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Current Email address" required><b>Current Password:</b><br />
        <label for="inputPassword" class="sr-only">Current Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Current Password" required><br /><b>New Email:</b><br />
        <label for="inputEmail" class="sr-only"><b>New Email address</b></label>
        <input type="email" name="newemail" id="inputEmail" class="form-control" placeholder="New Email address" required><b>New Password:</b><br />
        <label for="inputPassword" class="sr-only"><b>New Email address</b></label>
        <input type="password" name="newpassword" id="inputPassword" class="form-control" placeholder="New Password" required><br />
        <button type="submit" class="btn btn-primary" name="submitUpdatePE">Update Email & Password</button>
      </form>
      <?php
      if (isset($_POST['submitUpdatePE'])) {
        updatePE(returnMemberID());
      }
      if (isset($_POST['uploadImage']) && isset($_SERVER['REQUEST_URI'])) {
        uploadImage(0, returnMemberID());
      }
      ?>
      <form action="myAccount.php" method="POST">
        <div class="row">
          <div class="col-lg-12 pt-5">

            <p><i>WARNING: THIS CANNOT BE UNDONE</i></p><br />
            <button style="float:left; background-color:red;" onclick="return confirm('Are you sure?')" type="submit" class="btn btn-primary" name="deleteAccount">Delete Account</button>
          </div>

        </div>
      </form>
  </div>

  </div>

  </div>

  <footer>
    <div class="container">
      <p>&copy; Bandermatch 2019. All Rights Reserved.</p>
      <ul class="list-inline">
        <li class="list-inline-item">
          <a href="contact.php">Contact</a>
        </li>
        <li class="list-inline-item">
          <a href="about.php">About</a>
        </li>
        <li class="list-inline-item">
          <a href="FAQ.php">FAQ</a>
        </li>
      </ul>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/new-age.min.js"></script>
</body>

</html>