<?php include('config.php'); ?>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>User Profile</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet" />
        <link href="css/style.css" rel="stylesheet">
        <!-- <link href="assets/css/regStyle.css" rel="stylesheet"> -->
    </head>
    <body>
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
              <li class="active"><a href="#home">Home</a></li>
              <li><a href="#profile">profile</a></li>
			  <li><a href="#search">Search</a></li>
              <li><a href="#logout">log out</a></li>
            </ul>
          </div>
          <!-- /.Navbar-collapse -->
        </div>
      </div>
      <!-- /.container -->
    </nav>
  </div>
  <!-- /Navigation -->
  <br>
  <br>
  <br>
  <br>
  <!-- /Sign Up form -->
  <div class="signup-form">
    <div class="container">
      <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <form class="form" action="regForm.php" method="POST" enctype="multipart/form-data">

        <h2 class="text-center">Register</h2>
        <hr>

        <div class="form-group <?php echo isset($errors['full_name']) ? 'has-error' : '' ?>">
          <label class="control-label">Full Name</label>
            <input type="text" name="full_name" value="<?php echo $full_name; ?>" class="form-control">
              <?php if (isset($errors['full_name'])): ?>
              <span class="help-block"><?php echo $errors['full_name'] ?></span>
              <?php endif; ?>
              
        </div>

        <div class="form-group <?php echo isset($errors['age']) ? 'has-error' : '' ?>">
          <label class="control-label">Age</label>
            <input type="text" name="age" value="<?php echo $age; ?>" class="form-control">
              <?php if (isset($errors['age'])): ?>
              <span class="help-block"><?php echo $errors['age'] ?></span>
              <?php endif; ?>
              
        </div>

        <div class="form-group <?php echo isset($errors['gender']) ? 'has-error' : '' ?>">
          <label class="control-label">Gender: </label>
            <input type="radio" name="gender" value="<?php echo $gender; ?>" required>Male
            <input type="radio" name="gender" value="<?php echo $gender; ?>">Female
            <input type="radio" name="gender" value="<?php echo $gender; ?>">Other
                
            
            <?php if (isset($errors['gender'])): ?>
              <span class="help-block"><?php echo $errors['gender'] ?></span>
            <?php endif; ?>
            
        </div>
        

   

        <div class="form-group <?php echo isset($errors['interests']) ? 'has-error' : '' ?>">
          <label class="control-label">Interests: </label>
            <input type="radio" name="interests" value="<?php echo $interest; ?>" required>Dogs
            <input type="radio" name="interests" value="<?php echo $interest; ?>" >Basketball
            <input type="radio" name="interests" value="<?php echo $interest; ?>">Soccer
            <input type="radio" name="interests" value="<?php echo $interest; ?>">Yeet
            <input type="radio" name="interests" value="<?php echo $interest; ?>">Penis
                
            
            <?php if (isset($errors['interests'])): ?>
              <span class="help-block"><?php echo $errors['interests'] ?></span>
            <?php endif; ?>
            
        </div>

        <div class="form-group <?php echo isset($errors['beard_type']) ? 'has-error' : '' ?>">
          <label class="control-label">Beard Type: </label>
            <input type="radio" name="beard_type" value="<?php echo $interest; ?>" required>None
            <input type="radio" name="beard_type" value="<?php echo $interest; ?>" >Stubble
            <input type="radio" name="beard_type" value="<?php echo $interest; ?>">Short
            <input type="radio" name="beard_type" value="<?php echo $interest; ?>">Medium<br>
            <input type="radio" name="beard_type" value="<?php echo $interest; ?>">Long
                
            
            <?php if (isset($errors['beard_type'])): ?>
              <span class="help-block"><?php echo $errors['beard_type'] ?></span>
            <?php endif; ?>
            
        </div>
        
        

        <div class="form-group <?php echo isset($errors['motto']) ? 'has-error' : '' ?> " >
          <label class="control-label">Motto</label>
            <input type="text" name="motto" value="<?php echo $motto; ?>" class="form-control">
              <?php if (isset($errors['motto'])): ?>
              <span class="help-block"><?php echo $errors['motto'] ?></span>
              <?php endif; ?>
              
        </div>

        <div class="form-group <?php echo isset($errors['bio']) ? 'has-error' : '' ?>">
          <label class="control-label">Bio</label>
            <input type="text" name="bio" value="<?php echo $bio; ?>" class="form-control">
              <?php if (isset($errors['bio'])): ?>
              <span class="help-block"><?php echo $errors['bio'] ?></span>
              <?php endif; ?>
             
        </div>

        

        <div class="form-group">
            <button type="submit" name="register_btn" class="btn btn-success btn-block">Save Profile</button>
        </div>

        </form>
      </div>
      </div>
    </div>
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
  
    </body>
</html>