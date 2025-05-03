output "private_subnet_id" {
  description = "value of private subnet id"
  value       = aws_subnet.private_subnet.id
}

output "public_subnet_id" {
  description = "value of public subnet id"
  value       = aws_subnet.public_subnet.id
}

output "vpc_id" {
  description = "value of vpc id"
  value       = aws_vpc.main_vpc.id
}