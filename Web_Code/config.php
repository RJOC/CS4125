<?php
session_start();

$servername = "localhost:3306";
$username = "root";
$password = "";

$db = new mysqli($servername, $username, $password, "dance");

if($db->connect_error){
    die("Connection failed: " . $db->connect_error);
}

echo "Connected successfully";

define ('ROOT_PATH', realpath(dirname(__FILE__))); 
    define ('INCLUDE_PATH', realpath(dirname(__FILE__) . '/includes' )); 
    // Add URL definition
    define('BASE_URL', '');
    
    function getMultipleRecords($sql, $types = null, $params = []) {
        global $conn;
        $stmt = $conn->prepare($sql);
        if (!empty($params) && !empty($params)) { // parameters must exist before you call bind_param() method
          $stmt->bind_param($types, ...$params);
        }
        $stmt->execute();
        $result = $stmt->get_result();
        $user = $result->fetch_all(MYSQLI_ASSOC);
        $stmt->close();
        return $user;
      }
      function getSingleRecord($sql, $types, $params) {
        global $conn;
        $stmt = $conn->prepare($sql);
        $stmt->bind_param($types, ...$params);
        $stmt->execute();
        $result = $stmt->get_result();
        $user = $result->fetch_assoc();
        $stmt->close();
        return $user;
      }
      function modifyRecord($sql, $types, $params) {
        global $conn;
        $stmt = $conn->prepare($sql);
        $stmt->bind_param($types, ...$params);
        $result = $stmt->execute();
        $stmt->close();
        return $result;
      }
