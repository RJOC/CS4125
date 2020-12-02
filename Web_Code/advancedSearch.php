<?php include('config.php') ?>
<?php include(INCLUDE_PATH . '/logic/userSignup.php'); ?>
<!--collect user info-->
<?php
$connection = mysqli_connect("localhost:3306", "17204097", "mMzaj7h7LJXe", "d17204097");
$log_ID ="";
$seeking_gender = "";
$seeking_rel = "";
$maxAge = "";
$minAge = "";
$log_ID ="";
if(isset($_POST['search'])){
$seeking_gender = $_POST['gender'];
$seeking_rel = $_POST['lookingFor'];
$maxAge = $_POST['maxAge'];
$minAge = $_POST['minAge'];

$query = "SELECT * FROM users";
$conditions = array();

if(!empty(seeking_gender)) {
  array_push($conditions,"gender='$seeking_gender'");
}

if(!empty(seeking_rel)) {
  array_push($conditions,"looking_for='$seeking_rel'");
}

$sql = $query;
if(count($conditions) > 0){
  $sql .= " WHERE age BETWEEN $minAge AND $maxAge AND ".implode(' AND ', $conditions);
}


$output ="";
$query = mysqli_query($connection, $sql) or die; 
$count = mysqli_num_rows($query);
if($count == 0){
    $output = 'No search results found';
} else {
    while($row = mysqli_fetch_array($query)) {

        $profile_pic = $row['profile_picture'];
        $name = $row['username'];
        $bio = $row['bio'];
        $output .= '<div> '.$name. '</div>';

      
    }
}
}
?>
<!DOCTYPE HTML>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Search</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet" />
        <link href="css/style.css" rel="stylesheet">
        <link href="search_style.css" rel="stylesheet">
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
  <form id="search_form" name="search_from" method="post" action="advancedSearchResults.php"
  <div class="container">
  <section class="col-lg-12">
  <h3>Preferred gender</h3>
  <input type="radio" name="gender" value="male"> Male 
  <input type="radio" name="gender" value="female"> Female
  <input type="radio" name="gender" value="other"> Both <br>
  <br>
  <h3>Looking for</h3>
  <input type="radio" name="lookingFor" value="long-term"> Long-term dating 
  <input type="radio" name="LookingFor" value="short-term"> Short-term dating
  <input type="radio" name="LookingFor" value="hookup"> Hookup <br>
  <input type="radio" name="LookingFor" value="friends"> friends 
  <input type="radio" name="LookingFor" value="fwb"> Friends with benefits
  <input type="radio" name="LookingFor" value="chats"> chats<br>
  <br>
  <h3>Age Range</h3>
  <label for="maxAge">Max Age:</label> 
  <input type="number" name="maxAge" class="form-control" id="maxAge" min="18" max="120" value="120" placeholder="Max Age"> 
  <label for="maxAge">Min Age:</label> 
  <input type="number" name="minAge" class="form-control" id="minAge" min="18" max="120" value="18" placeholder="Min Age"> 
  <label for="btn" class="submitSearchbtn">
    <input type="submit" id="btn" value="search"/> </label>

</form>
</section>
</div>
<br>
<br>
<br>

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
  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>

</html>