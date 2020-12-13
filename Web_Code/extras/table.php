<?php

            try {
                $con = new PDO('mysql:host=localhost;dbname=dance', "root", "");
                $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                $query = "SELECT payment, date FROM payments WHERE studentID=2";
                //first pass just gets the column names
                $result = $con->query($query);
                //return only the first row (we only need field names)
                $row = $result->fetch(PDO::FETCH_ASSOC);
                print " <tr> a";
                foreach ($row as $field => $value) {
                    print " <th>$field</th> b";
                } // end foreach
                print "<br>";
                //second query gets the data
                $data = $con->query($query);
                $data->setFetchMode(PDO::FETCH_ASSOC);
                foreach ($data as $row) {
                    print " <tr> d";
                    foreach ($row as $name => $value) {
                        print " <td>$value</td> e";
                    } // end field loop
                    print " </tr><br>";
                } // end record loop
                print "</table> g";
            } catch (PDOException $e) {
                echo 'ERROR: ' . $e->getMessage();
            } // end try

            ?>