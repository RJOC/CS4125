<?php

require("dbc.php");

function getUsersData($id)
{
	$array = array();
	$q = mysql_query("SELECT * FROM `users` WHERE `id`=".$id);
	while($r = mysql_fetch_assoc($q))
	{
		$array['id'] = $r['id'];
		$array['username'] = $r['username'];
		$array['password'] = $r['password'];
		$array['full_name'] = $r['full_name'];
		$array['age'] = $r['age'];
		$array['email'] = $r['email'];
        $array['motto'] = $r['motto'];
        $array['bio'] = $r['bio'];
		
	}
	return $array;
}

function getId($username)
{
	$q = mysql_query("SELECT `id` FROM `users` WHERE `username`='".$username."'");
	while($r = mysql_fetch_assoc($q))
	{
		return $r['id'];
	}
}

function userExists($id)
{
	$numrows = mysql_num_rows(mysql_query("SELECT `id` FROM `users` WHERE `id`=".$id));
	if($numrows==1)
		return true;
	else
		return false;
}

function updateFullname($id,$full_name)
{
	if(mysql_query("UPDATE `users` SET `firstname`='".$full_name."' WHERE `id`=".$id))
		return true;
	else
		return false;
}

function updateBio($id,$bio)
{
	if(mysql_query("UPDATE `users` SET `bio`='".$bio."' WHERE `id`=".$id))
		return true;
	else
		return false;
}

function updateMotto($id,$motto)
{
	if(mysql_query("UPDATE `users` SET `motto`='".$motto."' WHERE `id`=".$id))
		return true;
	else
		return false;
}

function updateAge($id,$age)
{
	if(mysql_query("UPDATE `users` SET `age`='".$age."' WHERE `id`=".$id))
		return true;
	else
		return false;
}



function updateProfilePicture($id,$tmpName,$ext)
{
	if(move_uploaded_file($tmpName,"images/userimages/".$id.".".$ext) && mysql_query("UPDATE `users` SET `profileext`='".$ext."' WHERE `id`=".$id))
		return true;
	else
		return false;
}

function resetProfilePicture($id,$ext)
{
	if(unlink("images/userimages/".$id.".".$ext) && mysql_query("UPDATE `users` SET `profileext`='n/a' WHERE `id`=".$id))
		return true;
	else
		return false;
}

?>