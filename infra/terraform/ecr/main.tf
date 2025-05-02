resource "aws_ecr_repository" "foo" {
  name                 = "${var.service_name}-${var.server_name}"
  image_tag_mutability = "MUTABLE"

  image_scanning_configuration {
    scan_on_push = true
  }

  tags = {
    "IaC" = "terraform"
  }
}
