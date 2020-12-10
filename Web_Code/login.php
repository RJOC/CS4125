<?php 

$servername = "localhost:3306";
$user = "root";
$password = "";

$db = new mysqli($servername, $user, $password);

if(isset($_POST['username'])) {
    $username = $_POST['username'];
    echo $username;
}

// Using prepared statements almost eliminates the possibility of SQL Injection.
$preparedQuery = $db->prepare('SELECT * FROM `users` WHERE `username` = :username');
$preparedQuery->bind_param(':username', $username);
$preparedQuery->execute();

// Retrieve the results from the database
$user = $preparedQuery->fetch(PDO::FETCH_ASSOC);

// If there is a user record print the user & pass... 
if($username != ''){
    echo 'match';
    $_SESSION['username'] = $username;
} else if ($username == '') {
    echo 'no match';
} else {
    echo 'error';
}

?>