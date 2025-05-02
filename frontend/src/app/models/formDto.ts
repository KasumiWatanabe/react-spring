import { UseFormRegisterReturn } from "react-hook-form";

export interface FormDto<T extends string> {
  register: UseFormRegisterReturn<T>;
  hasError?: boolean;
  message?: string;
}
