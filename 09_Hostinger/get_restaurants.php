<?php

	require_once 'DbOperation.php';

	$db = new DbOperation();

	$restaurants = $db->getAllRestaurants();

	$response = array();

	$response['error'] = false;
	$response['restaurants'] = array();

	while($rest = $restaurants->fetch_assoc()){
		$temp = array();
		$temp['id']=$rest['id'];
		$temp['latlng']=$rest['latLng'];
		$temp['name']=$rest['name'];
		array_push($response['restaurants'],$temp);
	}

	echo json_encode($response);
