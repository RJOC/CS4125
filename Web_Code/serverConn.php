<?php
session_start();
$conn = mysqli_connect("localhost:3306", "dance", "root", "");

if($conn->connect_error){
    die("Connection failed: " . $conn->connect_error);
}

?>