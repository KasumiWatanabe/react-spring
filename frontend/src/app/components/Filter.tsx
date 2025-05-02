import { Stack, StackProps } from "@mui/material";
import { Button } from "./Button";

export type FilterType = "ALL" | "INCOMPLETE" | "COMPLETED";

export interface FilterProps {
  filterType: FilterType;
  setFilterType: (filter: FilterType) => void;
  sx?: StackProps["sx"];
}

export const Filter: React.FC<FilterProps> = (props) => {
  return (
    <Stack
      direction="row" // 横並びにする
      justifyContent="flex-end" // ボタンを右寄せ
      spacing={1} // ボタン間のスペース
      sx={{ ...props.sx }}
    >
      <Button
        label="全て"
        variant="contained"
        color={props.filterType === "ALL" ? "blue" : "normal"}
        onClick={() => props.setFilterType("ALL")}
      />
      <Button
        label="未完了のみ"
        variant="contained"
        color={props.filterType === "INCOMPLETE" ? "blue" : "normal"}
        onClick={() => props.setFilterType("INCOMPLETE")}
      />
      <Button
        label="完了のみ"
        variant="contained"
        color={props.filterType === "COMPLETED" ? "blue" : "normal"}
        onClick={() => props.setFilterType("COMPLETED")}
      />
    </Stack>
  );
};
