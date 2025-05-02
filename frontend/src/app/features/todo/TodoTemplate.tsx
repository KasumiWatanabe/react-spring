import { Stack } from "@mui/material";
import { FormDto } from "../../models/formDto";
import { TextInput } from "../../components/TextInput";
import { Button } from "../../components/Button";
import { Filter, FilterType } from "../../components/Filter";
import { CheckboxList, Item } from "../../components/CheckboxList";

export type TodoTemplateProps = {
  todoText: FormDto<"todoText">;
  filterType: FilterType;
  checkboxItems: Item[];
  setFilterType: (filter: FilterType) => void;
  onClickCreate: () => void;
  onClickDelete: (id: number) => void;
  onClickCheckbox: (id: number) => void;
};

export const TodoTemplate: React.FC<TodoTemplateProps> = (props) => {
  return (
    <Stack sx={{ mt: "10px", width: "40%", py: "30px", mx: "auto" }}>
      <Stack direction="row" spacing={1} sx={{ mb: "20px" }}>
        <TextInput
          placeholder="タスクを入力してください"
          formdto={props.todoText}
          sx={{ flexGrow: 1 }}
        />
        <Button
          label="追加"
          variant="contained"
          color="green"
          onClick={props.onClickCreate}
        />
      </Stack>
      <Filter
        filterType={props.filterType}
        setFilterType={props.setFilterType}
        sx={{ mb: "20px" }}
      />
      <CheckboxList
        items={props.checkboxItems}
        onClickCheckbox={props.onClickCheckbox}
        onClickDelete={props.onClickDelete}
      />
    </Stack>
  );
};
