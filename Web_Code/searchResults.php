<?php include('config.php') ?>
<!--collect user info-->
<?php
if(isset($_POST['search'])){
    $search_query = $_POST['search'];
    $search_query = preg_replace("#[^0-9a-z]#i","",$search_query);
    $connection = mysqli_connect("localhost:3306", "17204097", "mMzaj7h7LJXe", "d17204097");
    $output ="";
    $query = mysqli_query($connection,"SELECT * FROM users WHERE username LIKE '%$search_query%'") or die; 
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
  <br>
  <section class="col-lg-12">
  <div class="col-xs-2"></div>
  <div class="col-xs-8">
  <form action="searchResults.php" method="post">
    <input type="text" name="search" class="form-control" placeholder="Search for members"/> 
    </div>  
    <div class="col-xs-2">
    <input type="submit" value="Search"/>
    </div>  
</form>
</section>
<br>
<br>
    <div class="container">
        <hgroup class="margin-bottom-20">
            <h1>Search Results</h1>
            <h2 class="lead"><strong class="text-danger"><?php print("$count"); ?></strong> result(s) were found for the search for <strong class="text-danger"><?php print("$search_query");?></strong></h2>
        </hgroup>

        <?php foreach ($query as $key => $value): ?>
        <section class="col-lg-12">
            <article class="search-result row">
                <div class="col-lg-2">
                    <a href="#" title="profile pic" class="profile-pic" class="img-responsive img-circle"><img src="http://hive.csis.ul.ie/ET4243/group03/assets/images/<?php echo $value['profile_pic'] ?>"" alt="profile pic"></a>  
                </div>
                <div class="col-lg-2">
                    <ul class="search-info">
                        <li><i class="glyphicon glyphicon-heart"></i><span> <?php echo $value['looking_for'] ?></span></li>
                        <li><i class="glyphicon glyphicon-calendar"></i><span> <?php echo $value['age'] ?></span></li>
                        <li><i class="glyphicon glyphicon-user"></i><span><?php echo $value['gender'] ?></span></li> 
                    </ul>
                </div>
                <div class="col-lg-8">
                    <h3><a href="#" title="stephanie"><?php echo $value['username'] ?></a></h3>
                    <p><?php echo $value['bio'] ?></p>
                    <div class="searchButtons">
                        <button class="btn btn-success btn-sm">Save</button>
                        <button class="btn btn-danger btn-sm">Shave</button>
                    </div>
                    <span class="cleafix borda"></span>
                </div>
            </article>
        </section>
        
        <?php endforeach; ?>        
    </div>

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