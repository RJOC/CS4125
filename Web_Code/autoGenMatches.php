<?php include('config.php');



    
    $sql = "SELECT uiA.userID AS aID, uA.username as aName,uiB.userID AS bID, uB.username as bName, count(uiB.interests_id) AS interestsCount 
    FROM `users_interests` as uiA JOIN users_interests as uiB ON (uiA.interests_id = uiB.interests_id)
                                  JOIN users as uA on (uA.id = uiA.userID)
                                  JOIN users as uB on (uB.id = uiB.userID)
    WHERE uiA.userID = %d AND uiB.userID != %d
    GROUP BY bID
    ORDER BY interestsCount DESC";
 
    //try{$result = $conn->query(sprintf($sql, 1, 1));}
    //catch(Exception $e)
    //{echo $e;}
    echo "<pre>";   
    $result = $conn->query(sprintf($sql, 1, 1));
    $row2 = $result->fetch_array();
    while($row = $result->fetch_array())
    {
        echo $row["aID"];
        echo "\t";
        echo $row["aName"];
        echo "\t";
        echo $row["bID"];
        $bID = $row["bID"];
        echo "\t";
        echo $row["bName"];
        echo "\t";
        echo $row["interestsCount"];
        echo "\n";
    }
    echo "</pre>";
    //echo $bID;
     $pq = "SELECT * FROM users WHERE users.id ='$bID'";
    //$pq = "SELECT * FROM users WHERE users.id ='$sessionID'";
    $p = $conn->query($pq);
    $pr = $p->fetch_array();
    //print($pr['profile_picture']);
    
    // Print current user ID and get a list of the current user's interests
    //print("<br/>ID: " . $pr['id']);
    $sqlCurrentUserInterests = $conn->query("SELECT DISTINCT interests_id FROM users_interests WHERE userID = ".$pr['id']." ");

    // Convert interests into array and make a list of the interest IDs
    $interests = array();
    foreach ($sqlCurrentUserInterests as $row)
        array_push($interests, $row['interests_id']);

    // Debug interests
    // echo "<br/>Debug of current user interests:<br/>";
    // print_r($interests);
    // echo "<br/>";
    
    // Create a 2D array of interests, where each row corresponds to a list of userIDs who share this interests
    // Each row also corresponds to the interest from the previous list
    $interstLists = array();
    $i = 0;
    foreach($interests as $interestID)
    {
        // Get a list of users who also like this interest using the interestID
        $users = array();
        $userIDs = $conn->query("SELECT DISTINCT userID FROM users_interests WHERE interests_id = '$interestID'");
        // Add each userID into the users array
        foreach ($userIDs as $row)
            array_push($users, $row['userID']);

        // Debug print
        // echo "For interest $i<br/>";
        // print_r($users);
        // echo "<br/>";

        // Add list of users to the current row (who like the current interest)
        array_push($interstLists, $users);

        // Increment to next interest
        $i++;
    }

    // Debug print 2D array
    // echo "<br/>Debug of interests:<br/>";
    // print_r($interstLists);

    // Create a map of unique users to work as potential matches
    // Implemented as a key-value pair array
    // Eg: array['userID'] = 5 (Ie, 5 potential things in common)
    /*
        array(
            'userID' : key
            'IIC' : value (Interests in common)
        )
    */
    $potential_matches = array();

    // Iterate through list of intersts/users
    /*
        We'll be iterating through 2 things: 
        $interstLists
        $interests
        Each row in $interstLists corresponds to the ID in $interests
    */
    for ($i = 0; $i < sizeof($interstLists); $i++)
    {
        foreach ($interstLists[$i] as $user)
        {
            if (array_key_exists($user, $potential_matches))
                $potential_matches[$user]++;
            else
            {
                $potential_matches[$user] = 1;
            }
        }
    }

    // Debug print potential matches
    // print("<br/>Debug of potential matches<br/>");
    // print_r($potential_matches);

    // Sort array based on highest number of interests in common
    #rsort($potential_matches); // Highest value first, hence reverse sort

    // Debug print sorted potential matches
    // print("<br/>Debug of potential matches<br/>");
    // print_r($potential_matches);

    // Debug print all user data to show it is sorted
    // echo "<br/>";
    // print_r($user_data);
    // echo "<br/>";
    
    // NOTE: The rest is down below in the HTML code

    

    // --------------------- OLD CODE -----------------------------------

    //$sqlOtherUsersInterestsID = "SELECT userID FROM users_interests WHERE users_interests = '$aID'";
    //$sqlOtherUsersName = "SELECT username FROM users WHERE '$sqlCurrentUserInterests' = '$sqlOtherUsersInterests'";
    


 /*   $count = mysqli_num_rows($query);
    if($count == 0){
        $output = 'No results found';
    } else {
*/
        
/*        foreach($i = 0; $i < sizeof($sqlOtherUsersInterests);$i++)
        {
            echo $sqlOtherUsersInterests;
        }
*/
 /*       foreach($sqlOtherUsersInterestsID as $sqlOtherUsersInterestID)
        {
            echo $sqlOtherUsersInterestID;
        }
        */

/*        foreach(
            {
                echo 
            }
*/
    //right now not gonna search by the ammount of matches, but rather getting basic functionality working.
    // $conn->close();

//var_dump($result);
 ?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Mowie</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link href="css/animate.min.css" rel="stylesheet">
  <link href="css/animate.css" rel="stylesheet" />
  <link href="css/style.css" rel="stylesheet">

  <style>
    .centered {
      position: absolute;
      top: 90%;
      left: 50%;
      transform: translate(-50%, -50%);
      text-align: center;
      color: white;
      font-size: 200%;
      padding: 25px;
    }
    .goDown{
        padding: 80px;
    }
    </style>

</head>

<body>
  <!-- Navigation -->
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
              <li class="active"><a href="home.php">Home</a></li>
              <li><a href="personalprofile.php">Profile</a></li>
              <li><a href="search.php">Search</a></li>
              <li><a href="autoGenMatches.php">Suggestions</a></li>
              <li><a href="information.php">Information</a></li>
              <li><a href="logout.php">Logout</a></li>
            </ul>
          </div>
          <!-- /.Navbar-collapse -->
        </div>
      </div>
      <!-- /.container -->
    </nav>
  </div>
  <!-- /Navigation -->
        <div class="goDown">
        <table style="width:100%;padding:10px;">
            <th><tr>Your suggested matches:</tr></th>
            <!-- Sample matches table -->
            <?php
                // Get the user information for each user in the potential matches
                foreach ($potential_matches as $user => $interstsInCommon)
                {
                    $user_data = ($conn->query("SELECT * FROM users WHERE users.id = $user"))->fetch_array();
                
                    // You can now extract all data for this user
                    // This is where you would now format and echo HTML code
                    ?>
                        <tr class="userBox"> <!-- You can change this to whatever you want later -->
                            <td class="">User:    </td><td><?php echo $user_data['username']?></td>
                            <td class="">About me: </td><td><?php echo $user_data['bio']?></tds>
                        </tr>
                    <?php
                }
            ?>
        </table>
            </div>
        <!-- OLD CODE -->
        <!-- <table>
            <tr>
                <td>First user id</td>
                <td>First user's name</td>
                <td>Second user's id</td>
                <td>Second user's name</td>
                <td>Number of co-alligned interests</td>
            </tr>
            <tr>
                #<td><?php echo $row2["aID"]; ?></td>
                #<td><a href="<?php "$pr"?>"</a></td>
            </tr>
        </table> -->

    </body>
</html>