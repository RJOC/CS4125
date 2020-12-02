<?php
    if (isset($_POST['type']) && isset($_POST['shavee']) && isset($_SESSION['logID'])){
        $connection = mysqli_connect("localhost:3306", "17204097", "mMzaj7h7LJXe", "d17204097");
        $log_ID = preg_replace('#[^0-9]#i', '', $_SESSION['logID']);
        $shavee = preg_replace('#[^0-9]#i', '', $_POST['shavee']);
        $sql = "SELECT COUNT(id) FROM users WHERE id='$shavee'";
        $query = mysqli_query($connection, $sql);
        $exist_count = mysqli_fetch_row($query);
        if($exist_count[0] < 1){
            mysqli_close($connection);
            echo "User does not exist.";
            exit();
        }
        $sql = "SELECT ID FROM shaveSystem WHERE userID1='$log_ID' AND userID2='$shavee'";
        $query = mysqli_query($connection, $sql);
        $numrows = mysqli_fetch_row($query);
        if($_POST['type']=== "shave"){
            if ($numrows >> 0) {
                mysqli_close($connection);
                echo "You already have this user shaved";
                exit();
            } else {
                $sql = "INSERT INTO shaveSystem(userID1, userID2, shaveDate) VALUES('$log_ID', '$shavee', now())";
                $query = mysqli_query($connection, $sql);
                mysqli_close($connection);
                echo "shave_ok";
                exit();
            }
        } else if($_POST['type'] == "unshave") {
            if ($numrows == 0) {
                mysqli_close($connection);
                echo "You do not have this user shaved, you cannot unshave them";
                exit();  
            } else {
                $sql = "DELETE FROM shaveSystem WHERE userID1='$log_ID' AND userID2='$shavee'";
                $query = mysqli_query($connection, $sql);
                mysqli_close($connection);
                echo "unshave_ok";
                exit();
            }
        }
    }
?>