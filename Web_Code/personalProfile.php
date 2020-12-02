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
        <link href="style.css" rel="stylesheet">
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
    <div class="container">
        <div class="row profile">
        <?php $userData = getUserData(getID($_SESSION['username']));?>
        <?php if(userExists(mysql_real_escape_string($_GET['id']))){ ?>
		<div id="header">
			<?php echo $profileUsersData['full_name']."'s Profile"; ?>
        </div>
        <div id="wrapper">
            <div id="profilePicture">
                <?php
					if($profileUsersData['profileext']=="n/a")
						echo '<img src="images/profile.png" />';
					else
						echo '<img src="images/userimages/'.$profileUsersData['id'].'.'.$profileUsersData['profileext'].'" width="200" height="200" />';
				?>
            </div>
            <div id="aboutMe">
                <strong><u>About Me</u></strong><br />
                <?php echo $profileUsersData['aboutme']; ?>
            </div>
        </div>
        <div id="userDetails">
            <table width="200" border="0">
            	<tr>
                	<td width="55">Age:</td>
                    <td>
						<?php 
                             $difference = time() - $profileUsersData['birthday'];
							 $age = floor($difference / 31556926);
							 echo $age;
                        ?>
                    </td>
                </tr>
                <tr>
                	<td width="55">Country:</td>
                    <td><?php echo $profileUsersData['country']; ?></td>
				</tr>
                <tr>
                    <td width="55">City:</td>
                    <td><?php echo $profileUsersData['city']; ?></td>
				</tr>
            </table>
        </div>
        <?php } else echo "Invalid ID"; ?>
    	<?php 
	} 
	?>
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