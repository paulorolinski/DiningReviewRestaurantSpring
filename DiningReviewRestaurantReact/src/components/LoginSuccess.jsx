import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

export default function LoginError({open, setOpen}) {
  const navigate = useNavigate();

  const handleClose = () => {
    navigate("/restaurants")
  }

  return (
    <>
        <Dialog open={open} onClose={handleClose}>
          <DialogTitle>{"Login feito com sucesso!"}</DialogTitle>
          <DialogContent>
            <DialogContentText>
              Aproveite o app!
            </DialogContentText>
            <DialogActions>
              <Button onClick={handleClose} autoFocus>
                Fechar
              </Button>
            </DialogActions>
          </DialogContent>
        </Dialog>
    </>
  );
}
