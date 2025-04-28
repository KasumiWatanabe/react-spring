import { TextField, StackProps } from "@mui/material";
import { FormDto } from "../models/formDto";

export interface TextInputProps {
  placeholder?: string;
  formdto?: FormDto<string>;
  sx?: StackProps["sx"];
}

export const TextInput: React.FC<TextInputProps> = (props) => {
  return (
    <TextField
      {...props.formdto?.register}
      onChange={props.formdto?.register.onChange}
      onBlur={props.formdto?.register.onBlur}
      placeholder={props.placeholder}
      InputProps={{
        style: { height: "35px" },
      }}
      sx={{ ...props.sx }}
    ></TextField>
  );
};
