<?php
session_start();
$conn = mysqli_connect("localhost:3306", "17204097", "mMzaj7h7LJXe", "d17204097");

if($conn->connect_error){
    die("Connection failed: " . $conn->connect_error);
}


define ('ROOT_PATH', realpath(dirname(__FILE__))); 
    define ('INCLUDE_PATH', realpath(dirname(__FILE__) . '/includes' )); 
    define('BASE_URL', 'http://hive.csis.ul.ie/ET4243/group03/');
    
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
?>