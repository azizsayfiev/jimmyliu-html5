<?php

include ('Valite.php');

$valite = new Valite();
$valite->setImage('1.jpeg');
$valite->getHec();
$ert = $valite->run();
echo '<br><img src="2.jpeg"><br>';

?>