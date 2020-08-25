$(document)
.ready(
		function() {

			$("#pNameError").hide();
			$("#decError").hide();

			var pNameError = false;
			var decError = false;
		

			$("#pname").keyup(function() {
				validatepName();
			});
			$("#dec").keyup(function() {
				dec();
			});

			

			
			function validatepName() {

				var val = $("#pname").val();
				if (val == '') {
					$("#pNameError").show();
					$("#pNameError").html(
							"Name <b>Must Requeird </b>");
					$("#pNameError").css("color", "red");
					pnameError = false;
				} else {
					$("#pNameError").hide();
					pNameError = true;
				}
				return pNameError;
			}
			function dec() {

				var val = $("#dec").val();
				if (val == '') {
					$("#decError").show();
					$("#decError").html(
							"Name <b>Must Requeird </b>");
					$("#decError").css("color", "red");
					decError = false;
				} else {
					$("#decError").hide();
					decError = true;
				}
				return decError;
			}

			

			

			

			$("#register").click(
					function() {

						pNameError = false;
						decError = false;
				

						validatepName();
						dec()
					

						if (validatepName()
								&& dec())
							return true;
						else
							return false;

					});

		});
