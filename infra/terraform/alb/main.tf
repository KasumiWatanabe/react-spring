resource "aws_lb" "main" {
  name               = "${var.service_name}-alb"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.lb_sg.id]
  subnets            = [subnet-0921ed1255dfaacfb]

  access_logs {
    bucket  = aws_s3_bucket.access_logs.bucket
    prefix  = "test-lb"
    enabled = true
  }

  tags = {
    "IaC" = "terraform"
  }
}

resource "aws_s3_bucket" "access_logs" {
  bucket            = "test-lb-logs-tf"
  acl               = "private"

  lifecycle {
    prevent_destroy = true
  }

  versioning {
    enabled = false
  }

  tags = {
    "IaC" = "terraform"
  }
  
}