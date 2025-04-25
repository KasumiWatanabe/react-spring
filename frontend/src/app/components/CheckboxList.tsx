import {
  Checkbox,
  IconButton,
  List,
  ListItem,
  ListItemText,
} from "@mui/material";
import React from "react";
import DeleteIcon from "@mui/icons-material/Delete";

export type Item = {
  id: number;
  text: string;
  checked: boolean;
};

export interface CheckboxListProps {
  items: Item[];
  onClickCheckbox: (id: number) => void;
  onClickDelete: (id: number) => void;
}

export const CheckboxList: React.FC<CheckboxListProps> = (props) => {
  return (
    <List sx={{ width: "100%" }}>
      {props.items.map((item) => {
        return (
          <ListItem
            key={item.id}
            secondaryAction={
              <IconButton
                edge="end"
                onClick={() => props.onClickDelete(item.id)}
              >
                <DeleteIcon />
              </IconButton>
            }
            disablePadding
            sx={{ height: "55px", bgcolor: "#F5F5F5", marginBottom: "10px" }}
          >
            <Checkbox
              checked={item.checked}
              tabIndex={-1}
              disableRipple
              color="default"
              size="small"
              onClick={() => props.onClickCheckbox(item.id)}
            />
            <ListItemText primary={item.text} />
          </ListItem>
        );
      })}
    </List>
  );
};
