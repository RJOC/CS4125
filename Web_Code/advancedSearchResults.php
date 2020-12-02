<?php include('config.php') ?>

<!--collect user info-->
<?php
$connection = mysqli_connect("localhost:3306", "17204097", "mMzaj7h7LJXe", "d17204097");
$userID ="";
$seeking_gender = "";
$seeking_rel = "";
$log_ID ="";
if(isset($_SESSION['logID'])){
    $log_ID = $_SESSION['logID'];
    var_dump($log_ID);
}
if(isset($_POST['gender'])){
$seeking_gender = $_POST['gender'];
}
if(isset($_POST['lookingFor'])){
$seeking_rel = $_POST['lookingFor'];
}
$maxAge = (is_numeric ($_POST['maxAge']) ? (int)$_POST['maxAge'] : 120);
$minAge = (is_numeric ($_POST['minAge']) ? (int)$_POST['minAge'] : 18);


$query = "SELECT * FROM users";

$conditions = array();

if(!empty($seeking_gender)) {
  array_push($conditions,"gender='$seeking_gender'");
}

if(!empty($seeking_rel)) {
  array_push($conditions,"looking_for='$seeking_rel'");
}

$sql = $query;
if(count($conditions) > 0){
  $sql .= " WHERE age BETWEEN $minAge AND $maxAge AND ".implode(' AND ', $conditions);
}


$output ="";
$query = mysqli_query($connection, $sql); 
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


?>
<?php foreach ($query as $key => $value): ?>
        <?php
        $stringID = $value['id'];
        $userID = (int)$stringID;
        var_dump($userID);
        ?>
 
<?php 
$isSaved = false;
$ownerShavedViewer = false;
$viewerShavedOwner = false;
if ($userID != $log_ID){
    $saveCheck = "SELECT saveID FROM saveSystem WHERE userID1='$log_ID' AND userID2='$userID' OR userID1='$userID' AND userID2='$log_ID'";
    if(mysqli_num_rows(mysqli_query($connection, $saveCheck)) > 0){
        $isSaved = true;
    }

    $shaveCheck1 = "SELECT ID FROM shaveSystem WHERE userID1='$userID' AND userID2='$log_ID'";
    if(mysqli_num_rows(mysqli_query($connection, $shaveCheck1)) > 0){
        $ownerShavedViewer = true;
    }
    $shaveCheck2 = "SELECT ID FROM shaveSystem WHERE userID1='$log_ID' AND userID2='$userID'";
    if(mysqli_num_rows(mysqli_query($connection, $shaveCheck2)) > 0){
        $viewerShavedOwner = true;
    }
}
?>
<?php
    $save_Button = '<button class="btn btn-success btn-sm" disabled>Save</button>';
    $shave_Button = '<button class="btn btn-danger btn-sm" disabled>Shave</button>';
    // logic for save button
    if ($isSaved == true){
        $save_Button = '<button onclick="saveToggle(\'unSave\',\''.$userID.'\',\'saveBtn\')" class="btn btn-success btn-sm">unSave</button>'; 
    } else if ($userID != $log_ID && $ownerShavedViewer == false){
        $save_Button = '<button onclick="saveToggle(\'Save\',\''.$userID.'\',\'saveBtn\')" class="btn btn-success btn-sm">Save</button>';
    }
    //logic for shave button
    if($viewerShavedOwner == true){
        $shave_Button = '<button onclick="shaveToggle(\'unShave\',\''.$userID.'\',\'shaveBtn\')" class="btn btn-danger btn-sm">unShave</button>';
    } else if ($userID != $log_ID) {
        $shave_Button = '<button onclick="shaveToggle(\'Shave\',\''.$userID.'\',\'shaveBtn\')" class="btn btn-danger btn-sm">Shave</button>';
    }
?>
<?php endforeach; ?> 
<!DOCTYPE HTML>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Search</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet" />
        <link href="css/style.css" rel="stylesheet">
        <link href="search_style.css" rel="stylesheet">
</head>
<body>    

  <!-- /Navigation -->
  <br>
  <br>
  <br>
  <br>
   <section>
  <form id="search_form" name="search_from" method="post" action="advancedSearchResults.php">
  <div class="container">
  <section class="col-lg-12">
  <h3>Preferred gender</h3>
  <input type="radio" name="gender" value="male"> Male 
  <input type="radio" name="gender" value="female"> Female
  <input type="radio" name="gender" value="other"> Both <br>
  <br>
  <h3>Looking for</h3>
  <input type="radio" name="lookingFor" value="long-term"> Long-term dating 
  <input type="radio" name="lookingFor" value="short-term"> Short-term dating
  <input type="radio" name="lookingFor" value="hookup"> Hookup <br>
  <input type="radio" name="lookingFor" value="friends"> friends 
  <input type="radio" name="lookingFor" value="fwb"> Friends with benefits
  <input type="radio" name="lookingFor" value="chats"> chats<br>
  <br>
  <h3>Age Range</h3>
  <label for="maxAge">Max Age:</label> 
  <input type="number" name="maxAge" class="form-control" id="maxAge" min=18 max=120 value=120 placeholder="Max Age"> 
  <label for="minAge">Min Age:</label> 
  <input type="number" name="minAge" class="form-control" id="minAge" min=18 max=120 value=18 placeholder="Min Age"> 
  <label for="btn" class="submitSearchbtn">
    <input type="submit" id="btn" value="search"/> </label>
</div>
</form>
</section> 
<br>
<br>
    <div class="container">
        <hgroup class="margin-bottom-20">
        
            <h1>Search Results</h1>

            <h2 class="lead"><strong class="text-danger"><?php print("$count"); ?></strong> result(s) were found for the search for <strong class="text-danger">Advanced Search</strong></h2>
        </hgroup>

        <?php foreach ($query as $key => $value): ?>
        
        <section class="col-lg-12">
            <article class="search-result row">
                <div class="col-lg-2">
                    <a href="#" title="profile pic" class="profile-pic" class="img-responsive img-circle"> <img src="http://via.placeholder.com/150x150" id="profile_img" style="height: 150px; border-radius: 50%" alt=""></a>
                </div>
                <div class="col-lg-2">
                    <ul class="search-info">
                        <li><i class="glyphicon glyphicon-heart"></i><span> <?php echo $value['looking_for'] ?></span></li>
                        <li><i class="glyphicon glyphicon-calendar"></i><span> <?php echo $value['age'] ?></span></li>
                        <li><i class="glyphicon glyphicon-user"></i><span><?php echo $value['gender'] ?></span></li> 
 
                    </ul>
                </div>
                <div class="col-lg-8">
                    <h3><a href="#" title="username"><?php echo $value['username'] ?></a></h3>
                    <p><?php echo $value['bio'] ?></p>
                    <div class="searchButtons">
                        <span id="saveBtn"><?php echo $save_Button?></span>
                        <span id="shaveBtn"><?php echo $shave_Button?></span>
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
  <script src="http://hive.csis.ul.ie/ET4243/group03/js/ajax.js"></script>
<script type="text/javascript">
    function saveToggle(type, user, elem){
        var conf = confirm("Press OK to '"+type+"' user");
        if(conf != true){
            return false;
        }
        _(elem).innerHTML = 'please wait...';
        var ajax = ajaxObj("POST", "http://hive.csis.ul.ie/ET4243/group03/includes/logic/saveSystem.php");
        ajax.onreadystatechange = function() {
            if(ajaxReturn(ajax) == true) {
                if(ajax.responseText == "save_request_sent"){
                    _(elem).innerHTML = 'Save Request Sent';
                } else if(ajax.responseText == "unsave_ok"){
                    _(elem).innerHTML = '<button onclick="saveToggle(\'save\',\'<?php echo $userID; ?>\',\'saveBtn\')" class="btn btn-success btn-sm">Save</button>';
                } else {
                    alert(ajax.responseText);
                    _(elem).innerHTML = 'Try again later';
                }
            }
        }
        ajax.send("type="+type+"$userID"+user);
    }

    function shaveToggle(type, user, elem){
        var conf = confirm("Press OK to '"+type+"' user");
        if(conf != true){
            return false;
        }
        _(elem).innerHTML = 'please wait...';
        var ajax = ajaxObj("POST", "http://hive.csis.ul.ie/ET4243/group03/includes/logic/shaveSystem.php");
        ajax.onreadystatechange = function() {
            if(ajaxReturn(ajax) == true) {
                if(ajax.responseText == "shave_ok"){
                    _(elem).innerHTML = '<button onclick="shaveToggle(\'shave\',\'<?php echo $userID; ?>\',\'shaveBtn\')" class="btn btn-danger btn-sm">unShave</button>';
                } else if (ajax.responseText == "unshave_ok"){
                    _(elem).innerHTML = '<button onclick="shaveToggle(\'shave\',\'<?php echo $userID; ?>\',\'shaveBtn\')" class="btn btn-danger btn-sm">Shave</button>';
                    alert(ajax.responseText);
                    _(elem).innerHTML = 'Try again later';
                }
            }
        }
        ajax.send("type="+type+"&shavee"+userID);
    }
</script>
</body>

</html>