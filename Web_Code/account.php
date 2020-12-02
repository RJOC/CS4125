<?php include('config.php') ?>

<?php


if(!isset($_SESSION['username'])) header("location: ./");
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Profile System</title>
<link type="text/css" rel="stylesheet" href="styles.css" />
</head>

<body>

<div id="container">
	<div id="menu">
		<a href="index.php">Profile</a>
		<a href="account.php">Account</a>
		<a href="logout.php">Logout</a>
	</div>
    <?php $usersData = getUsersData(getId($_SESSION['username'])); ?>
    <strong><u>Update Your Name</u></strong>
    <form action="account.php?update=name" method="POST">
    	First Name: <input type="text" maxlength="50" name="full_name" value="<?php if(isset($_POST['full_name'])) echo trim(mysql_real_escape_string($_POST['full_name'])); else echo $usersData['full_name']; ?>" /><br />
        <input type="submit" name="nameSubmit" value="Update" />
    </form>
	<?php
		if(isset($_GET['update']) && $_GET['update']=="name")
		{
			$full_name = trim(mysql_real_escape_string($_POST['full_name']));
			
			$errors = array();
			if(strlen($full_name)>50)
				$errors[] = "Your name is too long";
			
				
			if(empty($errors))
			{
				if(updateFullname($usersData['id'],$full_name))
					echo "Updated!";
				else
					echo "An Error Has Occurred!";
			}
			else
				foreach($errors as $e)
					echo $e."<br />";
		}
	?>
    <hr />
    <strong><u>Update Bio</u></strong>
    <form action="account.php?update=bio" method="POST">
    	<textarea name="bio" maxlength="255" rows="5" cols="30"><?php if(isset($_POST['bio'])) echo trim(mysql_real_escape_string($_POST['bio'])); else echo $usersData['bio']; ?></textarea><br />
        <input type="submit" name="bioSubmit" value="Update" />
    </form>
    <?php
		if(isset($_GET['update']) && $_GET['update']=="bio")
		{
			$bio = trim(mysql_real_escape_string($_POST['bio']));
			
			$errors = array();
			if(strlen($bio)>255)
				$errors[] = "Your bio is too long";
				
			if(empty($errors))
			{
				if(updateBio($usersData['id'],$bio))
					echo "Updated!";
				else
					echo "An Error Has Occurred!";
			}
			else
				foreach($errors as $e)
					echo $e."<br />";
		}
	?>
    <hr />
    <strong><u>Update Birthday</u></strong>
    <form action="account.php?update=age" method="POST">
	Age: <input type="text" maxlength="3" name="age" value="<?php if(isset($_POST['age'])) echo trim(mysql_real_escape_string($_POST['age'])); else echo $usersData['age']; ?>" /><br />
		
        <input type="submit" name="ageSubmit" value="Update" />
    </form>
    <?php
		if(isset($_GET['update']) && $_GET['update']=="age")
		{
			$age = $_POST['age'];
			
			
			
			
			if(updateBirthday($usersData['id'],$age))
				echo "Updated!";
			else
				echo "An Error Has Occurred!";
		}
	?>
    <hr />
    <<strong><u>Update Motto</u></strong>
    <form action="account.php?update=motto" method="POST">
    	<textarea name="motto" maxlength="50" rows="5" cols="30"><?php if(isset($_POST['motto'])) echo trim(mysql_real_escape_string($_POST['motto'])); else echo $usersData['motto']; ?></textarea><br />
        <input type="submit" name="mottoSubmit" value="Update" />
    </form>
    <?php
		if(isset($_GET['update']) && $_GET['update']=="motto")
		{
			$motto = trim(mysql_real_escape_string($_POST['motto']));
			
			$errors = array();
			if(strlen($motto)>50)
				$errors[] = "Your motto is too long";
				
			if(empty($errors))
			{
				if(updateBio($usersData['id'],$motto))
					echo "Updated!";
				else
					echo "An Error Has Occurred!";
			}
			else
				foreach($errors as $e)
					echo $e."<br />";
		}
	?>
    <hr />
    <strong><u>Update Profile Picture</u></strong><br />
    <i>Allowed Extensions: *.jpg *.jpeg *.png</i>
    <form action="account.php?update=profilePicture" method="POST" enctype="multipart/form-data">
    	<input type="file" name="profilePicture" /> <input type="submit" name="profilePictureSubmit" value="Update">
    </form>
    <?php if($usersData['profileext']!="n/a"){ ?>
    	<form action="account.php?update=resetProfilePictureStep1" method="POST" >
    		<input type="submit" name="profilePictureStep1Submit" value="Reset">
    	</form>
    <?php } ?>
    <?php if(isset($_GET['update']) && $_GET['update']=="resetProfilePictureStep1"){ ?>
    	<form action="account.php?update=resetProfilePictureStep2" method="POST" >
        	<input type="hidden" name="resetProfilePictureID" value="<?php echo $usersData['id']; ?>">
            This will permanently delete the image from the server. Please confirm.
    		<input type="submit" name="profilePictureStep2Submit" value="Confirm Reset">
    	</form>
    <?php } ?>
    <?php
		if(isset($_GET['update']) && $_GET['update']=="profilePicture")
		{
			$type = $_FILES["profilePicture"]["type"];
			$size = $_FILES["profilePicture"]["size"];
			
			$errors = array();
			if($type == "image/jpeg" || $type == "image/jpg" || $type == "image/png")
			{
				$explode = explode(".",$_FILES["profilePicture"]["name"]);
				$ext = end($explode);
			}
			else
				$errors[] = "File Format Not Allowed!";
			if($size > 1048576)
				$errors[] = "File Size Too Big! 1MB Limit";
			
			if(empty($errors))
			{
				if(updateProfilePicture($usersData['id'],$_FILES["profilePicture"]["tmp_name"],$ext))
					echo "Updated!";
				else
					echo "An Error Has Occurred!";}
			else
				foreach($errors as $e)
					echo $e."<br />";
		}
		
		if(isset($_GET['update']) && $_GET['update']=="resetProfilePictureStep2")
		{
			$id = mysql_real_escape_string($_POST['resetProfilePictureID']);
			if(resetProfilePicture($usersData['id'],$usersData['profileext']))
					echo "Updated!";
				else
					echo "An Error Has Occurred!";
		}
	?>
</div>

</body>
</html>