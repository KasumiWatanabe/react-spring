import { Button as MButton, StackProps } from "@mui/material";

export interface ButtonProps {
  label: string;
  variant: "text" | "contained" | "outlined";
  color: "blue" | "green" | "normal";
  onClick?: () => void;
  sx?: StackProps["sx"];
}

export const Button: React.FC<ButtonProps> = (props) => {
  return (
    <MButton
      variant={props.variant}
      disableElevation
      onClick={props.onClick}
      disableRipple
      sx={{
        height: "35px",
        width: "100px",
        px: "12px",
        borderRadius: "35px",
        ...(props.color === "blue" && { backgroundColor: "#31B3C7" }),
        ...(props.color === "green" && { backgroundColor: "#006400" }),
        ...(props.color === "normal" && { backgroundColor: "#D3D3D3" }),

        "&:hover": {
          ...(props.color === "blue" && { backgroundColor: "#31B3C7" }),
          ...(props.color === "green" && { backgroundColor: "#006400" }),
          ...(props.color === "normal" && { backgroundColor: "#D3D3D3" }),
        },

        ...props.sx,
      }}
    >
      {props.label}
    </MButton>
  );
};
